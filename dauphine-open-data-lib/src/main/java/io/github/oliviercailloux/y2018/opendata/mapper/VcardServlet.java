package io.github.oliviercailloux.y2018.opendata.mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@ApplicationPath("/")
@ApplicationScoped
public class VcardServlet {

	@Inject
	EntityManager em;
	
	@Transactional
	public void CreateImport() {
		VcardImport vcardImport = new VcardImport();
		VCard vcard = new VCard();
		Person person = vcardImport.VcardToPerson(vcard);
		em.persist(person);	
	}
}
