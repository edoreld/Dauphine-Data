package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.entity.Entity;

@Transactional
public abstract class AbstractDao<E extends Entity> implements Dao<E> {

	@PersistenceContext
	protected EntityManager em;

	protected final String tableName;
	protected final Class<E> entityClass;

	public AbstractDao(String tableName, Class<E> entityClass) {
		super();
		this.tableName = Preconditions.checkNotNull(tableName, "tableName");
		this.entityClass = Preconditions.checkNotNull(entityClass, "entityClass");
	}

	@PostConstruct
	public void postConstruct() {
		Preconditions.checkNotNull(em, "em");
	}

	@Override
	public List<E> findAll() {
		return em.createQuery("SELECT e FROM " + tableName + " e", entityClass).getResultList();
	}

	@Override
	public Optional<E> findOne(Long id) {
		Preconditions.checkNotNull(id, "id");
		return Optional.ofNullable(em.find(entityClass, id));
	}

	private boolean entityAlreadyExists(E entity) {
		return entity.getId() != null && findOne(entity.getId()).isPresent();
	}

	@Override
	public E persist(E entity) throws EntityAlreadyExistsDaoException {
		Preconditions.checkNotNull(entity, "entity");
		if (entityAlreadyExists(entity)) {
			throw new EntityAlreadyExistsDaoException();
		}
		em.persist(entity);
		return entity;
	}

	@Override
	public E merge(E entity) {
		Preconditions.checkNotNull(entity, "entity");
		return em.merge(entity);
	}

	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		Preconditions.checkNotNull(id, "id");
		final Optional<E> entityOpt = findOne(id);
		if (!entityOpt.isPresent()) {
			throw new EntityDoesNotExistDaoException();
		}
		em.remove(entityOpt.get());
	}

	@Override
	public void flush() {
		em.flush();
	}

}
