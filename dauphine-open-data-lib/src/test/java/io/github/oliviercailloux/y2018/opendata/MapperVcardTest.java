package io.github.oliviercailloux.y2018.opendata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.mapper.MapperVcard;

public class MapperVcardTest {
	
	@Test
	public void testPersonToVcard() {
		Person person = new Person();
		person.setFirstName("Omar");
		person.setLastName("Djalo");		
		MapperVcard MV = new MapperVcard();
		VCard vcard = MV.PersonToVcard(person);
		assertEquals("Omar",vcard.getStructuredName().getGiven());		
	}
}
