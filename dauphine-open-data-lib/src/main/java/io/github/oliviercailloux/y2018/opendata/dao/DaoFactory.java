package io.github.oliviercailloux.y2018.opendata.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.common.base.Preconditions;


/**
 * Factory of {@link Dao} implementations.<br />
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 */
/*
 * In order to add an implementation, you must write a new annotated public
 * instance method that returns the implementation.
 *
 * @Produces public XXXDao makeXXXDao() { return new XXXDao(entityManager); }
 *
 */
@RequestScoped
public class DaoFactory {

	@PersistenceContext
	private EntityManager entityManager;
	

	/**
	 * This constructor should not be used since this class requires field
	 * injection.<br />
	 */
	public DaoFactory() {
		// empty to add a warning in the javadoc
		
	}

	/**
	 * Checks whether the field injection worked.
	 *
	 * @throws NullPointerException If a field is null
	 */
	@PostConstruct
	private void checkFieldInitialized() {
		Preconditions.checkNotNull(entityManager, "entityManager");
	}

}
