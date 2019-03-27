package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String fax;

	/**
	 * this field represent the personal mail of the person.a person can have many
	 * personal mail
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "Personal_Mail_table")
	@XmlElementWrapper(name = "personalMails")
	@XmlElement(name = "personalMail")
	private List<String> personalMail = new LinkedList<>();

	/**
	 * a person in this context have mandatory dauphine mail so it can't be empty
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "dauphine_Mail_table")
	@XmlElementWrapper(name = "dauphineMails")
	@XmlElement(name = "dauphineMail")
	private List<String> dauphineMail = new LinkedList<>();

	/**
	 * This field is madatory and help to know the membership group
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "memberShip_table")
	@XmlElementWrapper(name = "memberShipMails")
	@XmlElement(name = "memberShipMail")
	private List<String> memberShip = new LinkedList<>();

	/**
	 * This field help to distinguish persons currentlty present(active) in the
	 * university and persons who leave the university.
	 */
	@NonNull
	@Column(nullable = false)
	@XmlElement
	private Boolean isActive;

	@Override
	public Long getId() {
		return id;
	}
}

