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
public class Person extends AbstractEntity {

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
	 * This fiel is also madatory all person mus have a lastname
	 */
	@NotNull
	private String LastName;

	/**
	 * This will help to distinguish student from teachers and is mandatory
	 */
	@NotNull
	private String accountType;

	/**
	 * This field represent National Student Identification code in case person is a
	 * student it will be filled with empty string if person is a teacher
	 */
	private String ine;

	/**
	 * This field help to check if person object is active or not
	 */
	private boolean isActive;

	/**
	 * This represent teacher's office when person is teacher
	 */
	private String office;

	/**
	 * This represent the phone number of the person
	 */
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
	 * this field represent the personnal mail of the person.a person can have many
	 * personal mail
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "personnalMail")
	private List<String> personnalMail;

	/**
	 * a person in this context have mandatory dauphine mail so it can't be null
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "dauphineMail")
	private List<String> dauphineMail;

	/**
	 * This field is madatory and help to know the membership group
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "memberShip")
	private List<String> memberShip;

	/**
	 * This represent the list of services allowed to the student
	 */
	@Column(nullable = false)
	@ElementCollection
	@CollectionTable(name = "accessServices")
	private List<String> accessServices;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Person() {
		super();
		accessServices = new ArrayList();
		personnalMail = new ArrayList();
		dauphineMail = new ArrayList();
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {

		return firstName;
	}

	/**
	 * as firstName is mandatory for all person, parameter @param firstName is also
	 * mandatory
	 */
	public void setFirstName(@NotNull String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return LastName;
	}

	/**
	 * as lastName is mandatory for all person, parameter @param lastName is also
	 * mandatory
	 */
	public void setLastName(@NotNull String lastName) {

		LastName = lastName;
	}

	public String getAccountType() {

		return accountType;
	}

	/**
	 * As accountType is mandatory for all person, parameter @param accountType is
	 * also mandatory
	 */
	public void setAccountType(@NotNull String accountType) {

		this.accountType = accountType;

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
	 * @param office if this parameter is null, it will be convert to an empty
	 *               string
	 */
	public void setOffice(String office) {

		this.office = Strings.nullToEmpty(office);
	}

	/**
	 * 
	 * @return a list of services accesses of the person
	 */
	public List<String> getAccessServices() {

		return Collections.unmodifiableList(accessServices);
	}

	/**
	 *
	 * @param service
	 */
	public void addAccessServices(@NotNull String service) {

		this.accessServices.add(service);
	}

	public String getPhoneNumer() {

		return phoneNumer;
	}

	/**
	 * @param phoneNumer if this parameter is null, it will be remplaced by an empty
	 *                   string
	 */
	public void setPhoneNumer(String phoneNumer) {

		this.phoneNumer = Strings.nullToEmpty(phoneNumer);
	}

	public String getTraining() {

		return training;
	}

	/**
	 * 
	 * @param training will remplaced by empty string if it's null
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

	public List<String> getPersonnalMail() {

		return Collections.unmodifiableList(personnalMail);
	}

	/**
	 * 
	 * @param personnalMail is mandatory field
	 */
	public void addPersonnalMail(@NotNull String personnalMail) {

		this.personnalMail.add(personnalMail);
	}

	/**
	 * Return the ine wich is the National Student Identification code in case person is a
	 * student it will be filled with empty string if person is a teacher
	 */
	public String getIne() {

		return ine;
	}

	/**
	 * help to modifiy the National Student Identification code in case person is a
	 * student it will be filled with empty string if person is a teacher
	 */
	public void setIne(String ine) {

		this.ine = Strings.nullToEmpty(ine);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}