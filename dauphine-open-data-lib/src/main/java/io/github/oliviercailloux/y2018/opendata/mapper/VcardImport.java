package io.github.oliviercailloux.y2018.opendata.mapper;

import javax.enterprise.context.ApplicationScoped;

import ezvcard.VCard;
import ezvcard.parameter.TelephoneType;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

/**
 * @author Elhadj Diallo
 *
 */

@ApplicationScoped
public class VcardImport {
	
	public VcardImport() {}
	
	public Person VcardToPerson(VCard vcard) {
		
		Person person = new Person();
		
		person.setIsActive(true);
		
		if(vcard.getStructuredName().getFamily() != null) {
			person.setLastName(vcard.getStructuredName().getFamily()); 
		}
		
		if(vcard.getStructuredName().getGiven() != null) {
			person.setFirstName(vcard.getStructuredName().getGiven());
		}
		
		if(vcard.getUid().getValue() != null){
			person.setIne(vcard.getUid().getValue());
		}
		
		vcard.getTelephoneNumbers().stream()
			.filter(t -> t.getTypes().contains(TelephoneType.CELL))
			.findFirst()
			.ifPresent(t -> person.setPhoneNumer(t.getText()));
		
		vcard.getTelephoneNumbers().stream()
			.filter(t -> t.getTypes().contains(TelephoneType.FAX))
			.findFirst()
			.ifPresent(t -> person.setFax(t.getText()));
		
		if (!vcard.getNotes().isEmpty()) {
			person.setOffice(vcard.getNotes().get(0).getValue());
		}
				
		if(!vcard.getExpertise().isEmpty()) {
			person.setTraining(vcard.getExpertise().get(0).getValue());	
		}
		
		return person;
	}
}
