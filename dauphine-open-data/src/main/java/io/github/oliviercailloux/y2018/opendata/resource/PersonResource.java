package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ezvcard.VCard;
import ezvcard.Ezvcard;

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
	@Consumes("text/plain")
	public Response importVCard(String vCardString) throws EntityAlreadyExistsDaoException {
				
		VCard vcard = Ezvcard.parse(vCardString).first();
		VcardImport vcardImport = new VcardImport();
		this.dao.persist(vcardImport.VcardToPerson(vcard));
		return Response.ok("ok").build();
	}
}