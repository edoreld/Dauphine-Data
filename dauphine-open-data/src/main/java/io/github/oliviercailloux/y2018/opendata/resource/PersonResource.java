package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.PersonDao;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.mapper.VcardImport;

@Path("person")
public class PersonResource extends AbstractResource<Person, PersonDao> {

	public PersonResource() {
		super("Person", "person");
	}
	
	@POST
	@Path("importvcard")
	public void importVCard(VCard vcard ) throws EntityAlreadyExistsDaoException {
		VcardImport vcardImport = new VcardImport();

		this.dao.persist(vcardImport.VcardToPerson(vcard));	
	}
}