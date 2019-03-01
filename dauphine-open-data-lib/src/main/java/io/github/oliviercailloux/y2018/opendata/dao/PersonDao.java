package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.oliviercailloux.y2018.opendata.entity.Person;

/**
 * Represents class which will help to manipulate Person Objet <br />
 * Every method rejects null argument.
 *
 * @author Dauphine - GANDI Taric
 */
@Transactional
@RequestScoped
public class PersonDao implements Dao<Person> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * This method help to find all records of person saved in DB
	 */

	@Override
	public List<Person> findAll() {

		return entityManager.createQuery("SELECT e FROM Person e", Person.class).getResultList();
	}

	/**
	 * Help to remove record of person with given id
	 */
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {

		final Person person = entityManager.find(Person.class, id);
		if (person != null) {
			entityManager.remove(person);
		}
	}

	/**
	 * Help to find a record with given id
	 */
	@Override
	public Optional<Person> findOne(Long id) {

		final Optional<Person> person = Optional.of(entityManager.find(Person.class, id));
		return person;
	}

	/**
	 * Help to save an record of person
	 */
	@Override
	public Person persist(Person entity) throws EntityAlreadyExistsDaoException {

		entityManager.persist(entity);
		return entity;
	}

	/**
	 * help in merging an object person given person as param
	 */
	@Override
	public Person merge(Person entity) {

		return entityManager.merge(entity);
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

}
