package io.github.oliviercailloux.y2018.opendata.mapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.github.oliviercailloux.y2018.opendata.entity.Course;

/**
 * 
 * this class allows the conversion of a java object into XML elements
 * 
 * and from XML elements to build java objects from the class Race
 *
 * @author Mohamed EL AMRANI
 */

public class CourseXML {

	/**
	 * @param courses entity to encode cannot be null
	 * 
	 * @param file    path to store the XML file
	 * 
	 */
	public void encodeCourse(Course courses, String file) throws Exception {
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(new File("src\\main\\resources\\xsd\\CDMv2.01.xsd"));

			// creation the JAXB contexte under the Course classe
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);

			// creation of the marshaller from this contexte
			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setSchema(schema);

			// write the XML file on the fileName
			marshaller.marshal(courses, new File(file));
			marshaller.marshal(courses, System.out);

		} catch (JAXBException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param file path to decode the XML file to course object
	 * 
	 * @return courses list of course object
	 */
	public List<Course> decodeCourse(String file) throws Exception {
		List<Course> courses = new ArrayList<Course>();
		File inputFile = new File(file);
		DocumentBuilderFactory docBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		NodeList ndList = doc.getElementsByTagName("course");

		for (int temp = 0; temp < ndList.getLength(); temp++) {
			Node nNode = ndList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Course c = new Course();
				Element eElement = (Element) nNode;
				c.setCourseID(eElement.getElementsByTagName("courseID").item(0).getTextContent());
				c.setCourseName(eElement.getElementsByTagName("courseName").item(0).getTextContent());
				c.setCourseDescription(eElement.getElementsByTagName("courseDescription").item(0).getTextContent());
				c.setInstructionLanguage(eElement.getElementsByTagName("instructionLanguage").item(0).getTextContent());
				courses.add(c);

			}
		}
		return courses;
	}

}
