package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Provides a basic implementation of class Person.<br />
 * Person is either Student or Teacher. In this class you have basic attributes
 * to manipulate class Person and getters an setters. In our code INE is the
 * acronym of National Student Identification All our getters should not return
 * null string All our method get for a List are protected from unsafe
 * modification we handle the adding of null value in a list by making mandatory
 * parameter of method modifying a list <br />
 * This class contain NamedQuaries That help to make easy request to get information about a person
 * Three fields are chosen to make request by filtering :
 * {@link Person#firstName  }
 * {@link Person#lastName   }
 * {@link Person#training   }
 * 
 * @author Gandi Taric
 */

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class Person implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	private static final long serialVersionUID = -4768931293875213592L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	/**
	 * Firstname field mandatory
	 */
	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String firstName;

	/**
	 * This field is also madatory all person mus have a lastname
	 */
	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String lastName;

	/**
	 * This field represent National Student Identification code in case person is a
	 * student it will be filled with empty string if person is a teacher
	 */
	@Column(nullable = true)
	@XmlElement
	private String ine;

	@Column(nullable = true)
	@XmlElement
	private String office;

	@Column(nullable = true)
	@XmlElement
	private String phoneNumer;

	/**
	 * this field represent the training of the student and will be set to empty
	 * string if it is a teacher
	 */
	@Column(nullable = true)
	@XmlElement
	private String training;

	/**
	 * This represent fax of the person
	 */
	@Column(nullable = true)
	@XmlElement
	private String fax;

	/**
	 * this field represent the mail of the person.a person can have many mail
	 */
	@Column(nullable = false)
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Mail")
	@XmlElementWrapper(name = "mails")
	@XmlElement(name = "mail")
	private List<String> mails = new ArrayList<>();

	/**
	 * This field help to distinguish persons currentlty present(active) in the
	 * university and persons who leave the university.
	 */
	@NonNull
	@Column(nullable = false)
	@XmlElement
	private Boolean isActive;

}
