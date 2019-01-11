/**
 * 
 */
package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import io.github.oliviercailloux.y2018.opendata.entity.Planning;

/**
 * @author elhadj oumar diallo
 *
 */

public class PlanningDao extends AbstractDao<Planning>  {
	/**
	 * This contructor expects both managed entity manager
	 * 
	 * @param entityManager a managed entity manager
	 */
	
	public PlanningDao (final EntityManager entityManager) {
		super(entityManager, Planning.class, "Planning");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Planning> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e" );
		return query.getResultList();
	}

	@Override
	public Optional<Planning> findOne(Long id) {
		Optional<Planning> planning = Optional.of(entityManager.find(Planning.class, id));
		return planning;
		
	}

	@Override
	public Planning persist(Planning entity) throws EntityAlreadyExistsDaoException {
		if(!entityManager.contains(entity))
			entityManager.persist(entity);
		return entity;
	}

	@Override
	public Planning merge(Planning entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		Query query = entityManager.createNativeQuery("DELETE FROM " +entityClass.getSimpleName() + " WHERE ID = " +id);
		query.executeUpdate();
		
	}

}
