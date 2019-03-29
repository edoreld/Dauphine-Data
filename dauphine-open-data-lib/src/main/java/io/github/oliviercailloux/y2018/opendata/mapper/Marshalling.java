package io.github.oliviercailloux.y2018.opendata.mapper;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import src.main.resources.xjc.Course;
import src.main.resources.xjc.InfoBlockType;
import src.main.resources.xjc.InstructionLanguage;
/**
 * 
 * this class allows the conversion of a java object into XML elements
 *
 * @author Mohamed EL AMRANI
 */

public class Marshalling {

	/**
	 * 
	 * @param file    path to store the XML file
	 * 
	 */
	public static void Marshal(String file) throws JAXBException {
		Course c1 = new Course();
		c1.setCourseID("Course 1");
		c1.setCourseName("JAVA");
		InfoBlockType infoBlockType=new InfoBlockType();
		infoBlockType.setBlockLang("Apprendre a programmer en orienté objet");
		c1.setCourseDescription(infoBlockType);
		InstructionLanguage language=new InstructionLanguage();
		language.setTeachingLang("English");
		c1.setInstructionLanguage(language);
		// the other attributes to be added according to needs ....

		JAXBContext context = JAXBContext.newInstance(Course.class);

		// Marshalling [Generate XML from JAVA]
		Marshaller marshaller = context.createMarshaller();
		// To format the [to be]generated XML output
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Marshall it and write output to System.out or to a file
		marshaller.marshal(c1, System.out);
		marshaller.marshal(c1, new File(file));
	}
		
	}