package io.github.oliviercailloux.y2018.opendata.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Here is a basic implementation for the class Planning
 * 
 * @author elhadj diallo
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Planning extends AbstractEntity {	

	private static final long serialVersionUID = -5050839598082807501L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@OneToMany
	@JoinColumn(nullable = false)
	private String planningName;
/*
	@OneToMany
	@JoinColumn(nullable = false)
	private List<Lecture> lectures = new ArrayList<>();

	@OneToOne
	@JoinColumn(nullable = false)
	private Person person;
*/
	public Planning () {}
	
	/**
	 * Constructor
	 */
	
	public Planning (String planningName,final Person person, final List<Lecture> lecture) {
		this.planningName = planningName;
//		this.person = Objects.requireNonNull(person);
//		this.lectures = Objects.requireNonNull(lecture);
	}

	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Returns sets this planning's name
	 */

	public String getPlanningName() {
		return planningName;
	}

	/**
	 * Sets this planning's name
	 */

	public void setPlanningName(String planningName) {
		this.planningName = planningName;
	}

	/**
	 * Returns this planning's person
	 */
/*
	public Person getPerson() {
		return person;
	}
*/
	/**
	 * sets this planning's person
	 */
/*
	public void setPerson(final Person person) {
		this.person = Objects.requireNonNull(person);
	}
*/
	/**
	 * Returns this planning's lectures
	 */
/*
	public List<Lecture> getLectures(){
		return lectures;
	}
*/
	/**
	 * Sets this planning's lectures.
	 */
/*
	public void setLectures(List<Lecture> lectures) {
		Objects.requireNonNull(lectures);
		this.lectures = lectures;
	}
*/	
	/**
	 * Adding a lecture to this planning's lectures
	 */
/*	
	public void AddLecture (final Lecture lecture) {
		this.lectures.add(Objects.requireNonNull(lecture));
	}
*/
}
