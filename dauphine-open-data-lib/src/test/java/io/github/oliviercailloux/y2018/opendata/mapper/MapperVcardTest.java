package io.github.oliviercailloux.y2018.opendata.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ezvcard.VCard;
import io.github.oliviercailloux.y2018.opendata.entity.Person;
import io.github.oliviercailloux.y2018.opendata.mapper.MapperVcard;

/**
 * @author Elhadj Diallo
 *
 */
public class MapperVcardTest {
	
	@Test
	public void testPersonToVcard() {
		Person person = new Person();
		person.setFirstName("firstNameTest");
		person.setLastName("lastNameTest");		
		MapperVcard MV = new MapperVcard();
		VCard vcard = MV.PersonToVcard(person);
		assertEquals("firstNameTest",vcard.getStructuredName().getGiven());
	}
}
