package io.github.oliviercailloux.y2018.opendata.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
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

	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private List<Lecture> lectures = new ArrayList<>();

	@NotNull
	@OneToOne
	@JoinColumn(nullable = false)
	private Person person;

	/**
	 * Constructor
	 */

	public Planning (final Person person, final List<Lecture> lecture) {
		this.person = Objects.requireNonNull(person);
		this.lectures = Objects.requireNonNull(lecture);
	}

	@Override
	public Long getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	/**
	 * Returns this planning's person
	 * 
	 * @return not <code>null</code>
	 */

	public Person getPerson() {
		return person;
	}

	/**
	 * sets this planning's person
	 * 
	 * @param person can't be <code>null</code>
	 */

	public void setPerson(final Person person) {
		this.person = Objects.requireNonNull(person);
	}

	/**
	 * Returns this planning's lectures
	 * 
	 * @return not <code>null</code>
	 */

	public List<Lecture> getLectures(){
		return lectures;
	}

	/**
	 * Sets this planning's lectures
	 * 
	 * @param lectures can't be <code>null</code>
	 */

	public void setLectures(List<Lecture> lectures) {
		Objects.requireNonNull(lectures);
		this.lectures = lectures;
	}

	/**
	 * Adding a lecture to this planning's lectures
	 * 
	 * @param lecture can't be <code>null</code>
	 */

	public void AddLecture (final Lecture lecture) {
		this.lectures.add(Objects.requireNonNull(lecture));
	}

}
