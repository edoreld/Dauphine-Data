package io.github.oliviercailloux.y2018.opendata.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	private String name;
	
	@ManyToMany
	private List<Lecture> lectures = new ArrayList<>();


	/**
	 * Constructor
	 */

	public Planning (String name, final List<Lecture> lecture) {
		this.name = name;
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
	 * Returns this planning's name
	 * 
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Sets this planning's name
	 * 
	 */
	
	public void setName(String name) {
		this.name = name;
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
	

	public void addLecture (final Lecture lecture) {
		this.lectures.add(Objects.requireNonNull(lecture));
	}

}
