package io.github.oliviercailloux.y2018.opendata.mapper;

import javax.enterprise.context.ApplicationScoped;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

@ApplicationScoped
public class VcardImport {
	
	public VcardImport() {}
	
	public Person VcardToPerson(VCard vcard) {
		
		Person person = new Person();
		
		if(vcard.getStructuredName().getFamily() != null) {
			person.setLastName(vcard.getStructuredName().getFamily()); 
		}
		
		if(vcard.getStructuredName().getGiven() != null) {
			person.setFirstName(vcard.getStructuredName().getGiven());
		}
		
		if(vcard.getTelephoneNumbers().get(0).getText() != null) {
			person.setPhoneNumer(vcard.getTelephoneNumbers().get(0).getText());	
		}
		
		if(vcard.getTelephoneNumbers().get(1).getText() != null) {
			person.setFax(vcard.getTelephoneNumbers().get(1).getText());
		}
		
		if(vcard.getNotes() != null) {
			person.setOffice(vcard.getNotes().toString());
		}
		
		if(vcard.getExpertise() != null) {
			person.setTraining(vcard.getExpertise().toString());	
		}
		
		return person;
	}
}
