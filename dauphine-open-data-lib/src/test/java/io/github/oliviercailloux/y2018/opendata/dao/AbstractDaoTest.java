package io.github.oliviercailloux.y2018.opendata.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.github.oliviercailloux.y2018.opendata.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RunWith(MockitoJUnitRunner.class)
public class AbstractDaoTest {

	static final String TABLE_NAME = "FakeEntity";
	static final Class<FakeEntity> ENTITY_CLASS = FakeEntity.class;
	
	@Mock
	private TypedQuery<FakeEntity> query;
	
	@Mock
	private EntityManager em;

	@InjectMocks
	private final FakeDao dao = new FakeDao();
	
	private void testNullInput(ExceptionalRunnable codeThatShouldFails, Runnable assertionsToMake) {
		try {
			codeThatShouldFails.run();
			fail("no exception");
		} catch (NullPointerException e) {
			// expected assertion
			assertionsToMake.run();
		} catch (Exception e) {
			fail("no null pointer exception");
		}
	}
	
	@Test
	public void testPostConstruct() {
		dao.postConstruct();
	}
	
	private void testFindAll(List<FakeEntity> entitiesToReturn) {
		given(query.getResultList()).willReturn(entitiesToReturn);
		given(em.createQuery(anyString(), eq(ENTITY_CLASS))).willReturn(query);
		final List<FakeEntity> returnedEntities = dao.findAll();
		assertEquals("entities KO", entitiesToReturn, returnedEntities);
		then(em).should(atLeastOnce()).createQuery(anyString(), eq(ENTITY_CLASS));
		then(query).should(atLeastOnce()).getResultList();
	}
	
	@Test
	public void testFindAllEmpty() {
		testFindAll(Collections.emptyList());
	}
	
	@Test
	public void testFindAllMany() {
		testFindAll(Arrays.asList(FakeEntity.make(), FakeEntity.make()));
	}
	
	@Test
	public void testFindOne() {
		final FakeEntity fakeEntitiyToFind = FakeEntity.make();
		given(em.find(eq(ENTITY_CLASS), eq(fakeEntitiyToFind.getId()))).willReturn(fakeEntitiyToFind);
		final Optional<FakeEntity> returnedEntityOpt = dao.findOne(fakeEntitiyToFind.getId());
		assertTrue("empty optional", returnedEntityOpt.isPresent());
		assertEquals("returned entity KO", fakeEntitiyToFind, returnedEntityOpt.get());
		then(em).should(atLeastOnce()).find(eq(ENTITY_CLASS), eq(fakeEntitiyToFind.getId()));
	}
	
	@Test
	public void testFindOneNotExisting() {
		final Long idToFind = -1L;
		given(em.find(eq(ENTITY_CLASS), eq(idToFind))).willReturn(null);
		final Optional<FakeEntity> returnedEntityOpt = dao.findOne(-1L);
		assertFalse("not empty optional", returnedEntityOpt.isPresent());
		then(em).should(atLeastOnce()).find(eq(ENTITY_CLASS), eq(idToFind));
	}
	
	@Test
	public void testFindOneNullId() {
		testNullInput(() -> dao.findOne(null), () -> Mockito.verifyZeroInteractions(em));
	}
	
	@Test
	public void testMerge() {
		final FakeEntity mergedEntity = FakeEntity.make();
		final FakeEntity entityToMerge = FakeEntity.make();
		given(em.merge(eq(entityToMerge))).willReturn(mergedEntity);
		final FakeEntity returnedEntity = dao.merge(entityToMerge);
		assertEquals("returned entity KO", mergedEntity, returnedEntity);
		then(em).should(atLeastOnce()).merge(entityToMerge);
	}
	
	@Test
	public void testMergeNullInput() {
		testNullInput(() -> dao.merge(null), () -> Mockito.verifyZeroInteractions(em));
	}
	
	@Test
	public void testPersistNullInput() {
		testNullInput(() -> dao.persist(null), () -> Mockito.verifyZeroInteractions(em));
	}
	
	@Test
	public void testRemoveNullInput() {
		testNullInput(() -> dao.remove(null), () -> Mockito.verifyZeroInteractions(em));
	}
	
	@Test
	public void testRemoveExisting() {
		final FakeEntity entityToRemove = FakeEntity.make();
		given(em.find(eq(ENTITY_CLASS), eq(entityToRemove.getId())))
				.willReturn(entityToRemove);
		try {
			dao.remove(entityToRemove.getId());
			then(em).should(atLeastOnce()).find(ENTITY_CLASS, entityToRemove.getId());
			then(em).should(atLeastOnce()).remove(entityToRemove);
		} catch (EntityDoesNotExistDaoException e) {
			fail("the entity exists");
		}
	}
	
	@Test
	public void testRemoveNonExisting() {
		final Long wrongId = -1L;
		given(em.find(eq(ENTITY_CLASS), eq(wrongId)))
			.willReturn(null);
		try {
			dao.remove(wrongId);
			fail("the entity does not exist");
		} catch (EntityDoesNotExistDaoException e) {
			then(em).should(atLeastOnce()).find(ENTITY_CLASS, wrongId);
			then(em).should(never()).remove(Mockito.any());
		}
	}
	
	@Test
	public void testPersistNonExisting() {
		final FakeEntity entityToPersist = new FakeEntity(null, "test-name");
		Mockito.doNothing().when(em).persist(eq(entityToPersist));
		try {
			final FakeEntity persistedEntity = dao.persist(entityToPersist);
			then(em).should(never()).find(Mockito.any(), Mockito.any());
			then(em).should(atLeastOnce()).persist(entityToPersist);
		} catch (EntityAlreadyExistsDaoException e) {
			fail("the entity does not exist");
		}
	}
	
	@Test
	public void testPersistAlreadyExisting() {
		final FakeEntity existingEntity = FakeEntity.make();
		given(em.find(eq(ENTITY_CLASS), eq(existingEntity.getId())))
			.willReturn(existingEntity);
		try {
			dao.persist(existingEntity);
			fail("the entity exists");
		} catch (EntityAlreadyExistsDaoException e) {
			then(em).should(atLeastOnce()).find(eq(ENTITY_CLASS), eq(existingEntity.getId()));
			then(em).should(never()).persist(Mockito.any());
		}
	}
	
	@Test
	public void testPersistNotExistingId() {
		final FakeEntity existingEntity = FakeEntity.make();
		given(em.find(eq(ENTITY_CLASS), eq(existingEntity.getId())))
			.willReturn(null);
		try {
			dao.persist(existingEntity);
			then(em).should(atLeastOnce()).find(eq(ENTITY_CLASS), eq(existingEntity.getId()));
			then(em).should(atLeastOnce()).persist(existingEntity);
		} catch (EntityAlreadyExistsDaoException e) {
			fail("the entity does not exist");
		}
	}

	
	@Test
	public void flush() {
		dao.flush();
		then(em).should(atLeastOnce()).flush();
	}

}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
class FakeEntity implements Entity {

	private static final AtomicLong INC = new AtomicLong();
	
	@Nullable
	private Long id;

	@NotNull
	private String name;

	@Override
	public Long getId() {
		return id;
	}
	
	public static FakeEntity make() {
		return new FakeEntity(INC.incrementAndGet(), "test-name");
	}

}

class FakeDao extends AbstractDao<FakeEntity> {

	public FakeDao() {
		super(AbstractDaoTest.TABLE_NAME, AbstractDaoTest.ENTITY_CLASS);
	}

}

@FunctionalInterface
interface ExceptionalRunnable {
	void run() throws Exception;
}