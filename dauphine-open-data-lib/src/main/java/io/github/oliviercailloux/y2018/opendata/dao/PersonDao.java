package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.Collections;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@RequestScoped
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

		if (lastName.isEmpty() && firstName.isEmpty() && training.isEmpty()) {

			return Collections.<Person>emptyList();
		}

		CriteriaBuilder criteriabuilder = em.getCriteriaBuilder();
		CriteriaQuery<Person> querybuild = criteriabuilder.createQuery(Person.class);
		Root<Person> root = querybuild.from(Person.class);

		if (!lastName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("firstName"), "%" + lastName + "%"));
		}
		if (!firstName.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("firstName"), "%" + firstName + "%"));
		}
		if (!training.isEmpty()) {
			querybuild.where(criteriabuilder.like(root.get("training"), "%" + training + "%"));
		}
		TypedQuery<Person> queryTyped = em.createQuery(querybuild);
		return queryTyped.getResultList();
	}
}
