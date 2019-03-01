package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.y2018.opendata.entity.Planning;

/**
 * @author elhadj diallo
 *
 */
@Transactional
@RequestScoped
public class PlanningDao implements Dao<Planning> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * The method allows to find the schedules recorded in the database
	 */

	@Override
	public List<Planning> findAll() {
		return entityManager.createQuery("SELECT e FROM S e", Planning.class).getResultList();
	}

	/**
	 * Allows to find for a record with iD
	 */

	@Override
	public Optional<Planning> findOne(Long id) {
		return Optional.of(entityManager.find(Planning.class, id));

	}

	/**
	 * Allows to save an record of schedule
	 */

	@Override
	public Planning persist(Planning entity) throws EntityAlreadyExistsDaoException {
		entityManager.persist(entity);
		return entity;
	}

	/**
	 * Allows to merge planning objects
	 */

	@Override
	public Planning merge(Planning entity) {
		return entityManager.merge(entity);
	}

	/**
	 * Allows to remove a schedule record using the id
	 */

	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		final Planning planning = entityManager.find(Planning.class, id);
		if (planning != null) {
			entityManager.remove(planning);
		}
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

}
