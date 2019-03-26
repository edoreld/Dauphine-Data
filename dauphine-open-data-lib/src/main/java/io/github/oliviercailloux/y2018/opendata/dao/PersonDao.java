package io.github.oliviercailloux.y2018.opendata.dao;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.y2018.opendata.entity.Person;

@RequestScoped
public class PersonDao extends AbstractDao<Person> {

	public PersonDao() {
		super("Person", Person.class);
	}

}
