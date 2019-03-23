package io.github.oliviercailloux.y2018.opendata.mapper;

import ezvcard.VCard;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.StructuredName;
import io.github.oliviercailloux.y2018.opendata.entity.Person;


/**
 * @author Elhadj Diallo
 * 
 * This class convert a person entity into an VCard entity
 * 
 * * Use of the Vcard 4.0 version
 */

public class MapperVcard {
	
	public MapperVcard() {

	}
	
	/**
	 * @param person entity to encode cannot be null
	 * @return the person encoded as a VCard entity
	 */
	
	public VCard PersonToVcard(Person person) {

		VCard vcard = new VCard();
		StructuredName m = new StructuredName();
		m.setFamily(person.getLastName());
		m.setGiven(person.getFirstName());
		vcard.setStructuredName(m);

		person.getPersonalMail().forEach((personalMail) -> {
			vcard.addEmail(personalMail);
		});
		
		if(person.getOffice() != null) {
			vcard.addNote(person.getOffice());
		}
	
		if (person.getPhoneNumer() != null) {
			vcard.addTelephoneNumber(person.getPhoneNumer(), TelephoneType.CELL);
		}
		
		if (person.getFax() != null) {
			vcard.addTelephoneNumber(person.getFax(), TelephoneType.FAX);
		}
		
		if (person.getTraining() != null) {
			vcard.addExpertise(person.getTraining());
		}

		return vcard;
	}
}
