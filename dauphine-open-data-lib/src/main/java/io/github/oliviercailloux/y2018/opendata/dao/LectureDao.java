package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;



public class LectureDao extends AbstractDao< Lecture > {

	/**
	 * This constructor expects both managed entity manager.
	 *
	 * @param entityManager A managed entity manager
	 */
	public LectureDao(final EntityManager entityManager) {
		super(entityManager, Lecture.class, "Lecture");
	}
	/** 
	 * find all records of lecture in DB
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lecture> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
		return query.getResultList();
	}

/**
 * find one record of lecture in DB
 */
	@Override
	public Optional<Lecture> findOne(Long id) {
		return Optional.of(entityManager.find(entityClass, id));
	}
	/**
	 * Delete one record of lecture in DB by id
	 */
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		
		 Query query = entityManager.createNativeQuery("DELETE FROM Lecture WHERE ID = " + id);
		 query.executeUpdate();
	}

	@Override
	public Lecture persist(Lecture entity) throws EntityAlreadyExistsDaoException {
		if (!entityManager.contains(entity))
			entityManager.persist(entity);
		return entity;

	}

	@Override
	public Lecture merge(Lecture entity) {
		return entityManager.merge(entity);
	}
	

	}