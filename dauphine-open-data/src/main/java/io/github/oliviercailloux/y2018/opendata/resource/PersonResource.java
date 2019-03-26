package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.Path;

import io.github.oliviercailloux.y2018.opendata.dao.PersonDao;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@Path("person")
public class PersonResource extends AbstractResource<Person, PersonDao> {

	public PersonResource() {
		super("Person", "person");
	}

}
