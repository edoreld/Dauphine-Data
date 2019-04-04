package io.github.oliviercailloux.y2018.opendata.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

public class VcardImportTest {

	@Test
	public void TestEncodeVcardToPerson () {
		VCard vcard = new VCard();
		vcard.getStructuredName().setGiven("firstName");
		vcard.getStructuredName().setFamily("lastName");
		vcard.getTelephoneNumbers().get(0).setText("Telephone");
		vcard.getTelephoneNumbers().get(1).setText("Fax");
		
		VcardImport vcardImport = new VcardImport();
		Person person = vcardImport.VcardToPerson(vcard);
		assertEquals("firstName", person.getFirstName());
		assertEquals("lastName", person.getLastName());
	}
}
