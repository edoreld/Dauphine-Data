package io.github.oliviercailloux.y2018.opendata.mapper;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;

import ezvcard.VCard;

@ApplicationPath("/")
@ApplicationScoped
public class VcardServlet {

	@Inject
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<VcardImport> findAll() {
		return em.createQuery("SELECT c FROM VcardImport c").getResultList();
	}
	
	@Transactional
	public void CreateImport(VCard vcard) {
		VcardImport vcardImport = new VcardImport();
		em.persist(vcardImport);	
	}
}
