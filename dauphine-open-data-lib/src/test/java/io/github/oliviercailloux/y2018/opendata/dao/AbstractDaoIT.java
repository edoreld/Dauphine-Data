package io.github.oliviercailloux.y2018.opendata.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.codehaus.plexus.util.ReflectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import io.github.oliviercailloux.y2018.opendata.dao.Dao;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.EntityDoesNotExistDaoException;
import io.github.oliviercailloux.y2018.opendata.entity.Entity;

public abstract class AbstractDaoIT<E extends Entity, D extends Dao<E>> {

	protected D dao;

	@Inject
	private UserTransaction userTransaction;

	private final List<E> entitiesToDelete = Lists.newLinkedList();

	protected void setDao(final D dao) {
		this.dao = Preconditions.checkNotNull(dao, "dao");
	}

	protected abstract void setUpDao();

	@Before
	public void before() throws Exception {
		setUpDao();
		Preconditions.checkNotNull(dao, "dao");
	}

	@After
	public void after() throws Exception {
		final Iterator<E> itr = entitiesToDelete.iterator();
		E e;
		begin();
		while (itr.hasNext()) {
			e = itr.next();
			dao.remove(e.getId());
			itr.remove();
		}
		commit();
	}

	protected abstract E changeEntity(final E originalEntity);

	protected abstract E doMakeEntity();

	protected E makeEntity(final boolean persist, final boolean removeAfter) throws Exception {
		final E e = doMakeEntity();
		if (persist) {
			begin();
			dao.persist(e);
			commit();
		}
		if (removeAfter) {
			entitiesToDelete.add(e);
		}
		return e;
	}

	protected E makeEntity(final boolean persist) throws Exception {
		return makeEntity(persist, true);
	}

	protected E makeEntity() throws Exception {
		return makeEntity(true, true);
	}

	protected List<E> makeEntities(final int nb, final boolean persist, final boolean removeAfter) throws Exception {
		final List<E> entities = Lists.newLinkedList();
		for (int i = 0; i < nb; i++) {
			entities.add(makeEntity(persist, removeAfter));
		}
		return entities;
	}

	protected List<E> makeEntities(final int nb, final boolean persist) throws Exception {
		return makeEntities(nb, persist, true);
	}

	protected List<E> makeEntities(final int nb) throws Exception {
		return makeEntities(nb, true, true);
	}

	protected void begin() throws NotSupportedException, SystemException {
		userTransaction.begin();
	}

	protected void commit() throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {
		userTransaction.commit();
	}

	protected void rollback() throws IllegalStateException, SecurityException, SystemException {
		userTransaction.rollback();
	}

	@Test
	public void testFindAll() throws Exception {
		final List<E> persistedEntities = makeEntities(10);
		final List<E> foundEntities = dao.findAll();
		assertEquals("not the same size", persistedEntities.size(), foundEntities.size());
		assertTrue("an element was not found", foundEntities.containsAll(persistedEntities));
	}

	@Test
	public void testFindOne() throws Exception {
		final E persistedEntity = makeEntity();
		begin();
		final Optional<E> foundEntityOpt = dao.findOne(persistedEntity.getId());
		commit();
		assertTrue("no entity found", foundEntityOpt.isPresent());
		assertEquals("not the same course", persistedEntity, foundEntityOpt.get());

	}

	@Test
	public void testPersist() throws Exception {
		final E e = makeEntity(false, false);
		begin();
		final E persistedEntity = dao.persist(e);
		commit();
		entitiesToDelete.add(persistedEntity);
		begin();
		final Optional<E> foundEntityOpt = dao.findOne(persistedEntity.getId());
		commit();
		assertTrue("no entity found", foundEntityOpt.isPresent());
		assertEquals("not the same course", persistedEntity, foundEntityOpt.get());
	}

	@Test
	public void testPersistAlreadyExists() throws Exception {
		final E persistedEntity = makeEntity();
		try {
			begin();
			dao.persist(persistedEntity);
			commit();
			begin();
			dao.persist(persistedEntity);
			fail("the persist did not failed");
		} catch (final EntityAlreadyExistsDaoException e) {
			// expected exception
		} finally {
			rollback();
		}
	}

	@Test
	public void testMerge() throws Exception {
		final E persistedEntity = makeEntity();
		begin();
		final Optional<E> foundEntityOpt = dao.findOne(persistedEntity.getId());
		assertTrue("no entity found", foundEntityOpt.isPresent());
		assertEquals("not the same course before changing name", persistedEntity, foundEntityOpt.get());
		final E changedEntity = changeEntity(foundEntityOpt.get());
		final E foundEntity2 = dao.merge(changedEntity);
		commit();
		assertEquals("entity was not changed", changedEntity, foundEntity2);
	}

	@Test
	public void testRemoveNotExistingEntity() throws Exception {
		final E notPersistedEntity = makeEntity(false, false);
		ReflectionUtils.setVariableValueInObject(notPersistedEntity, "id", 12345L);

		try {
			begin();
			dao.remove(notPersistedEntity.getId());
			fail("the removal did not failed");
		} catch (final EntityDoesNotExistDaoException e) {
			// expected exception
		} finally {
			rollback();
		}
	}

	@Test
	public void testRemoveEntity() throws Exception {
		final E persistedEntity = makeEntity(true, false);
		begin();
		final Optional<E> foundEntityOpt = dao.findOne(persistedEntity.getId());
		assertTrue("no entity found", foundEntityOpt.isPresent());
		final E foundEntity = foundEntityOpt.get();
		assertEquals("not the same course", persistedEntity, foundEntity);
		dao.remove(foundEntity.getId());
		commit();
		begin();
		final Optional<E> deletedEntityOpt = dao.findOne(foundEntity.getId());
		assertFalse("course was not deleted", deletedEntityOpt.isPresent());
		commit();
	}

	@Test
	public void testRemoveId() throws Exception {
		final E persistedEntity = makeEntity(true, false);
		begin();
		final Optional<E> foundEntityOpt = dao.findOne(persistedEntity.getId());
		assertTrue("no entity found", foundEntityOpt.isPresent());
		final E foundEntity = foundEntityOpt.get();
		assertEquals("not the same course", persistedEntity, foundEntity);
		dao.remove(foundEntity.getId());
		commit();
		begin();
		final Optional<E> deletedEntityOpt = dao.findOne(foundEntity.getId());
		assertFalse("course was not deleted", deletedEntityOpt.isPresent());
		commit();
	}

	@Test
	public void testFlush() throws Exception {
		begin();
		dao.flush();
		rollback();
	}

}
