package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

/**
 * Represents class which will help to manipulate Person Objet <br />
 * Every method rejects null argument.
 * 
 * @author Dauphine - GANDI Taric
 */
public class PersonDao extends AbstractDao<Person> {

	/**
	 * Inheritance of constructor from super class AbstractDao
	 * 
	 * @param entityManager help to manage EntityManager
	 */
	public PersonDao(final EntityManager entityManager) {
		super(entityManager, Person.class, "Person");
	}

	/**
	 * This method help to find all records of person saved in DB
	 */
	
	@Override
	public List<Person> findAll() {

		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
		return query.getResultList();
	}

	/**
	 * Help to remove record of person with given id
	 */
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {

		Person person = entityManager.find(entityClass, id);
		if (person != null)
			entityManager.remove(person);
	}

	/**
	 * Help to find a record with given id
	 */
	@Override
	public Optional<Person> findOne(Long id) {

		Optional<Person> person = Optional.of((entityManager.find(Person.class, id)));
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

}
