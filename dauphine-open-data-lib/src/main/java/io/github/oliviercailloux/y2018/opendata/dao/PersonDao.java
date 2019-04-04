package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.Collections;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@Dependent
public class PersonDao extends AbstractDao<Person> {
	
	@PersistenceContext
	protected EntityManager em;

	public PersonDao() {

		super("Person", Person.class);
	}

	/**
	 * This method help to filter information about person(s) according some
	 * criteria
	 * 
	 * @param lastName  {@link Person#lastName } of a person
	 * @param firstName {@link Person#firstName} of a person
	 * @param training  {@link Person#training } of a person
	 * @return list of person filter by fields below
	 */
	public List<Person> findByCriteria(String lastName, String firstName, String training) {

		TypedQuery<Person> query = null ;
		
		if (lastName.isEmpty() && firstName.isEmpty() && training.isEmpty()) {

			return Collections.<Person>emptyList();
		}
		
		if(!lastName.isEmpty() && firstName.isEmpty() && training.isEmpty()) {
			query = em.createNamedQuery("FindPersonByLastName",Person.class);
			query.setParameter("lName", lastName);
		}
		
		if(!firstName.isEmpty() && lastName.isEmpty() && training.isEmpty()) {
			query = em.createNamedQuery("FindPersonByFirstName",Person.class);
			query.setParameter("fName", firstName);
		}
		
		if(!training.isEmpty() && firstName.isEmpty() && lastName.isEmpty()) {
			query = em.createNamedQuery("FindPersonByTraining",Person.class);
			query.setParameter("train", training);
		}
		
		if(training.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()) {
			query = em.createNamedQuery("FindPersonByFirstAndLastName",Person.class);
			query.setParameter("lName", lastName);
			query.setParameter("fName", firstName);
		}
		
		if(!training.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()) {
			query = em.createNamedQuery("FindPersonByFirstAndLastNameAndTraining",Person.class);
			query.setParameter("train", training);
			query.setParameter("lName", lastName);
			query.setParameter("fName", firstName);
		}
		  
		List<Person> persons = query.getResultList();                         
        return persons;
	}
}
