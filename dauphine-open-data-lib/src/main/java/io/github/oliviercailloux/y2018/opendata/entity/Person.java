package io.github.oliviercailloux.y2018.opendata.entity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.google.common.base.Strings;

/**
 * Provides a basic implementation of class Person.<br />
 * Person is either Student or Teacher. In this class you have basic attributes to
 * manipulate class Person and getters an setters
 * <br />
 * @author Gandi Taric
 */

@Entity
public class Person extends AbstractEntity {

	private static final long serialVersionUID = -4768931293875213592L;

	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return LastName;
	}

	public void setLastName(String lastName) {

		LastName = lastName;
	}

	public String getAccountType() {

		return accountType;
	}

	public void setAccountType(String accountType) {

		this.accountType = accountType;

	}

	public List<String> getMemberShip() {

		return memberShip;

	}

	public void setMemberShip(List<String> memberShip) {

		this.memberShip = memberShip;

	}
	
	public  List<String> getDauphineMail() {

		return Collections.unmodifiableList(dauphineMail);

	}

	public void setDauphineMail(String dauphineMail) {

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

	public void setAccessServices(String service) {

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

	public void setPersonnalMail(String personnalMail) {

		this.personnalMail.add(personnalMail);
	}

	public String getIne() {

		return ine;
	}

	public void setIne(String ine) {

		this.ine = Strings.nullToEmpty(ine);
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

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
	 * This field is madatory and help to know the membership group
	 */
	@NotNull
	private List<String> memberShip;

	/**
	 * a person in this context have mandatory dauphine mail so it can't be null
	 */
	@NotNull
	private List<String> dauphineMail;

	private String office;
	/**
	 * This represent the list of services allowed to the student 
	 */
	private List<String> accessServices;

	private String phoneNumer;
	
	/**
	 * this field represent the training of the student and will 
	 * be set to empty string if it is a teacher
	 */
	private String training;
	
    /**
     * This represent fax of the person
     */

	private String fax;
	
	/**
	 * this field represent the personnal mail of the person.a person can have many personal mail 
	 */

	private List<String> personnalMail;
	
	/**
	 * This field represent National Student code in case person is a student
	 * it will be filled with empty string if person is a teacher
	 */

	private String ine;
	
	/**
	 * This field help to check if person object is active or not
	 */

	private boolean isActive;

}