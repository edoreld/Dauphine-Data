package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
	 * @param entityManager
	 * @param entityClass
	 * @param entityName
	 */
	public PersonDao(EntityManager entityManager, Class<Person> entityClass, String entityName) {
		super(entityManager, entityClass, entityName);
	}

	/**
	 * This method help to find all records of person saved in DB
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {

		Query query = entityManager.createQuery("SELECT e FROM Person e");
		return query.getResultList();
	}

	/**
	 * Help to remove record of person with given id
	 */
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {

		Query query = entityManager.createNativeQuery("DELETE FROM Person WHERE ID = " + id);
		query.executeUpdate();
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

		executeInsideTransaction(entityManager -> entityManager.persist(entity));
		return entity;
	}

	/**
	 * help in merging an object person given person as param
	 */
	@Override
	public Person merge(Person entity) {

		executeInsideTransaction(entityManager -> entityManager.merge(entity));
		flush();
		return entity;
	}

	/**
	 * Help to handle safely save of records and handling exception by using
	 * rollback
	 * 
	 * @param action
	 */
	private void executeInsideTransaction(Consumer<EntityManager> action) {

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			action.accept(entityManager);
			transaction.commit();
		} catch (RuntimeException exception) {
			transaction.rollback();
			throw exception;
		}
	}
}
