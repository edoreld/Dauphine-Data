package io.github.oliviercailloux.y2018.opendata.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;

public class VcardImportTest {

	@Test
	public void TestEncodeVcardToPerson () {
		VCard vcard = new VCard();
		
		vcard.getStructuredName().setGiven("DUPOND");
		vcard.getStructuredName().setFamily("Olive");
		vcard.getTelephoneNumbers().get(0).setText("+33711111111");
		vcard.getTelephoneNumbers().get(1).setText("+33911111111");
		vcard.getNotes().get(2).setType("B400");
		
		VcardImport vcardImport = new VcardImport();
		Person person = vcardImport.VcardToPerson(vcard);
		
		assertEquals("Olive", person.getFirstName());
	}
}