package io.github.oliviercailloux.y2018.opendata.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import org.junit.Ignore;
import org.junit.Test;
import io.github.oliviercailloux.y2018.opendata.dao.PersonDao;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

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
			// no implementation required
		};
	}

	@Override
	protected Person makeEntity() {
		return new Person("test-firstname", "test-lastname", true);
	}
	
	@Override
	@Ignore
	public void testGetId() throws Exception {
		
	}
  
	@Test
	public void testSearch() throws Exception {
		final Person person = makeEntity();
		final Person persistedEntity = getDao().persist(person);
		sendJsonAcceptJsonUTF8English().put(Entity.json(persistedEntity));
		List<Person> persons = getDao().findByCriteria("test-lastname","test-firstname", "");
		assertEquals(persons.get(0).getLastName(),"test-lastname");
		assertEquals(persons.get(0).getFirstName(),"test-firstname");

	}
}
