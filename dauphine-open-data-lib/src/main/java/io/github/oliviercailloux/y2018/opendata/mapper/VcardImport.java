package io.github.oliviercailloux.y2018.opendata.mapper;

import javax.enterprise.context.ApplicationScoped;

import ezvcard.VCard;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.SimpleProperty;
import ezvcard.property.Telephone;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

import java.util.stream.Collectors;

/**
 * @author Elhadj Diallo
 * 
 * This class allows you to import a person's information from a VCard format
 * 
 * The VCard version to use is 4.0
 */

@ApplicationScoped
public class VcardImport {

	public VcardImport() {}
	
	/**
	 * @param lastName of the person
	 * @param firstName of the person
	 * @param ine of the person
	 * @param phoneNumber of the person
	 * @param fax of the person
	 * @param office of the person
	 * @param training of the person
	 * @param mails of the person
	 * 
	 * This method that takes a vcard as a parameter and converts it
	 * 
	 * @return person
	 */
	
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
			.ifPresent(t -> person.setPhoneNumer(getTelephoneTextOrUri(t)));

		vcard.getTelephoneNumbers().stream()
			.filter(t -> t.getTypes().contains(TelephoneType.FAX))
			.findFirst()
			.ifPresent(t -> person.setFax(getTelephoneTextOrUri(t)));

		if (!vcard.getNotes().isEmpty()) {
			person.setOffice(vcard.getNotes().get(0).getValue());
		}

		if(!vcard.getExpertise().isEmpty()) {
			person.setTraining(vcard.getExpertise().get(0).getValue());	
		}
		
		person.getMails().addAll(vcard.getEmails().stream().map(SimpleProperty::getValue).collect(Collectors.toList()));

		return person;
	}

	private static String getTelephoneTextOrUri(Telephone tel) {
		return tel.getUri() != null ? tel.getUri().getNumber() : tel.getText();
	}
}