package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author Gandi Taric <br>
 *         <br>
 * 
 *         This class provide additional methods to search a list of person
 *         according to some criteria <br>
 *         fields lastName, firstName and training are field most pertinent
 *         considered for requests
 */
@Path("person")
public class PersonResource extends AbstractResource<Person, PersonDao> {

	@PersistenceContext
	protected EntityManager em;

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractResource.class);

	public PersonResource() {
		super("Person", "person");
	}
  
	/**
	 * @param lastName  The lastName of given person
	 * @param firstName The firstName of given person
	 * @param training  The training of a person
	 * We make filter so easier. It can be possible to filter by only one of those fields below <br>
	 * or make combinaison of it like: filterby lastName and firstName or the 3 fields at the same time
	 * @return list of person according to the criteria if those parameters <br>
	 * are not set default empty string is affected to the parameter
	 * 
	 */
	@GET
	@Path("personfilter")
	public Response filterby(@DefaultValue("") @QueryParam("lastName") String lastName, @DefaultValue("") @QueryParam("firstName") String firstName ,
			                 @DefaultValue("") @QueryParam("training") String training) {

		LOGGER.info("[{}] - finding entities by nom [{}], prenom [{}] and cours [{}] ..", resourceName, lastName,
				firstName, training);
		List<Person> persons = dao.findByCriteria(lastName, firstName, training);
		return Response.ok(persons).build();

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
