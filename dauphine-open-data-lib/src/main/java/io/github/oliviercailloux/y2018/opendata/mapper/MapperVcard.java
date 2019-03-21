package io.github.oliviercailloux.y2018.opendata.mapper;

import ezvcard.VCard;
import ezvcard.property.StructuredName;
import io.github.oliviercailloux.y2018.opendata.entity.Person;


/**
 * @author Omardjalo
 * 
 * This class convert a person entity into an VCard entity
 */

public class MapperVcard {
	
	public MapperVcard() {

	}

	public VCard PersonToVcard(Person person) {

		VCard vcard = new VCard();
		StructuredName m = new StructuredName();
		m.setFamily(person.getLastName());
		m.setGiven(person.getFirstName());
		vcard.setStructuredName(m);
		vcard.setFormattedName(person.getFirstName() + " " + person.getLastName());

		person.getPersonalMail().forEach((personalMail) -> {
			vcard.addEmail(personalMail);

		});
		
		if(person.getOffice() != null) {
			vcard.addRole(person.getOffice());
		}

		if (person.getPhoneNumer() != null) {
			vcard.addTelephoneNumber(person.getPhoneNumer());
		}

		if (person.getTraining() != null) {
			vcard.addExpertise(person.getTraining());
		}

		if (person.getFax() != null) {
			vcard.addTelephoneNumber(person.getFax());
		}
		return vcard;
	}

}
