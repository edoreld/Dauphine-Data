package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@RequestScoped
@Transactional
public class LectureDao implements Dao<Lecture> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * find all records of lecture in DB
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lecture> findAll() {
		final Query query = entityManager.createQuery("SELECT l FROM Lecture l");
		return query.getResultList();
	}

	/**
	 * find one record of lecture in DB
	 */
	@Transactional
	@Override
	public Optional<Lecture> findOne(Long id) {
		return Optional.of(entityManager.find(Lecture.class, id));
	}

	/**
	 * Delete one record of lecture in DB by id
	 */
	@Transactional
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		final Query query = entityManager.createNativeQuery("DELETE FROM Lecture WHERE ID = " + id);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public Lecture persist(Lecture entity) throws EntityAlreadyExistsDaoException {
		if (!entityManager.contains(entity)) {
			entityManager.persist(entity);
		}
		return entity;

	}

	@Transactional
	@Override
	public Lecture merge(Lecture entity) {
		return entityManager.merge(entity);
	}

	@Transactional
	@Override
	public void flush() {
		entityManager.flush();
	}

}