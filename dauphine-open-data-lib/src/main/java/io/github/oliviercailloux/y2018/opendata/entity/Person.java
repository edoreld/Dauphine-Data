package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.google.common.base.Strings;

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
public class Person implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	private static final long serialVersionUID = -4768931293875213592L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Firstname field mandatory
	 */
	@NotNull
	private String firstName;

	/**
	 * This field is also madatory all person mus have a lastname
	 */
	@NotNull
	private String LastName;

	/**
	 * This field represent National Student Identification code in case person is a
	 * student it will be filled with empty string if person is a teacher
	 */
	private String ine;

	private String office;

	private String phoneNumer;

	/**
	 * this field represent the training of the student and will be set to empty
	 * string if it is a teacher
	 */
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
	private final List<String> personalMail;

	/**
	 * a person in this context have mandatory dauphine mail so it can't be empty
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "dauphine_Mail_table")
	private final List<String> dauphineMail;

	/**
	 * This field is madatory and help to know the membership group
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "memberShip_table")
	private List<String> memberShip;

	/**
	 * This field help to distinguish persons currentlty present(active) in the
	 * university and persons who leave the university.
	 */
	private boolean isActive;

	/**
	 * This field help to check if person is a student or not
	 */
	private boolean isStudent;

	public Person() {
		super();
		personalMail = new ArrayList<>();
		dauphineMail = new ArrayList<>();
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {

		return firstName;
	}

	/**
	 *
	 * @param is firstName of a given person
	 */
	public void setFirstName(@NotNull String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return LastName;
	}

	/**
	 * @param is the lastName of a given person
	 */
	public void setLastName(@NotNull String lastName) {

		LastName = lastName;
	}

	public List<String> getMemberShip() {

		return Collections.unmodifiableList(memberShip);

	}

	public void addMemberShip(@NotNull String memberShip) {

		this.memberShip.add(memberShip);

	}

	public List<String> getDauphineMail() {

		return Collections.unmodifiableList(dauphineMail);

	}

	public void addDauphineMail(@NotNull String dauphineMail) {

		this.dauphineMail.add(dauphineMail);

	}

	public String getOffice() {

		return office;
	}

	/**
	 * @param is name of an office
	 */
	public void setOffice(String office) {
		if (isStudent == false) {
			this.office = Strings.nullToEmpty(office);
		}
	}

	public String getPhoneNumer() {

		return phoneNumer;
	}

	/**
	 * @param is a phoneNumer of a given person
	 *
	 */
	public void setPhoneNumer(String phoneNumer) {

		this.phoneNumer = Strings.nullToEmpty(phoneNumer);
	}

	public String getTraining() {

		return training;
	}

	/**
	 *
	 * @param is a name of training
	 */
	public void setTraining(String training) {

		this.training = Strings.nullToEmpty(training);

	}

	public String getFax() {

		return fax;
	}

	public void setFax(String fax) {

		this.fax = Strings.nullToEmpty(fax);
	}

	public List<String> getPersonalMail() {

		return Collections.unmodifiableList(personalMail);
	}

	/**
	 *
	 * @param personnalMail is mandatory field
	 */
	public void addPersonalMail(@NotNull String personalMail) {

		this.personalMail.add(personalMail);
	}

	public String getIne() {

		return ine;
	}

	public void setIne(String ine) {
		if (isStudent) {
			this.ine = Strings.nullToEmpty(ine);
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setIsStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

}

