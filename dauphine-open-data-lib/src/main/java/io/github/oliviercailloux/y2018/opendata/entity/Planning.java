package io.github.oliviercailloux.y2018.opendata.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * Here is a basic implementation for the class Planning
 * 
 * Planning concerns all the courses of a person in particular 
 * a teacher over a given period of time
 * As there is a need for persistence, we have considered it as an entity
 * 
 * @author elhadj diallo
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Planning extends AbstractEntity {	

	private static final long serialVersionUID = -5050839598082807501L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	private List<Lecture> lectures = new ArrayList<>();


	/**
	 * Constructor
	 */

	public Planning (String name, Person person, final List<Lecture> lecture) {
		this.name = name;
		this.lectures = Objects.requireNonNull(lecture);
	}

	@Override
	public Long getId() {
		return id;
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
		this.lectures = Objects.requireNonNull(lectures);
	}

}
