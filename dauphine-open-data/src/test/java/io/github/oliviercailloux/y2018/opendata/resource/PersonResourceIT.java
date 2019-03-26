package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;

import org.junit.Ignore;

import io.github.oliviercailloux.y2018.opendata.dao.PersonDao;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@Ignore
public class PersonResourceIT extends AbstractResourceIT<Person, PersonDao> {

	@Inject
	private PersonDao dao;

	public PersonResourceIT() {
		super("person");
	}

	@Override
	protected PersonDao getDao() {
		return dao;
	}

	@Override
	protected GenericType<List<Person>> getEntitiesType() {
		return new GenericType<List<Person>>() {
		};
	}

	@Override
	protected Person makeEntity() {
		final Person c = new Person();
		c.setFirstName("test-firstname");
		c.setLastName("test-lastname");
		return c;
	}

}
