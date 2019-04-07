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
	
	/**
	 * @param lastName of the person
	 * @param firstName of the person
	 * @param ine of the person
	 * @param office of the person
	 * @param phoneNumber of the person
	 * @param training of the person
	 * @param fax of the person
	 * @param mail of the person
	 * 
	 * We use VcardImport to import VCard information 
	 * then we persist them using PersonDao
	 * 
	 * Accepted vcard versions are 4.0, 3.0 and 2.1
	 */
	
	@POST
	@Path("importvcard")
	@Consumes("text/vcard")
	public Response importVCard(String vCardString) throws EntityAlreadyExistsDaoException {
				
		VCard vcard = Ezvcard.parse(vCardString).first();
		VcardImport vcardImport = new VcardImport();
		this.dao.persist(vcardImport.VcardToPerson(vcard));
		return Response.ok("ok\n").build();
	}
}
