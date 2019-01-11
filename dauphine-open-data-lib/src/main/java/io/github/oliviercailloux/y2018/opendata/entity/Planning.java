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
 * @author Omardjalo
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
	private List<Lecture> lectures = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Person person;
	
	public Planning () {
		
	}
	
	public Planning (final Person person, final List<Lecture> lecture) {
		this.person = Objects.requireNonNull(person);
		this.lectures = Objects.requireNonNull(lecture);
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(final Person person) {
		this.person = Objects.requireNonNull(person);
	}
	
	
	public List<Lecture> getLectures(){
		return lectures;
	}
	
	public void addLecture(final Lecture lecture) {
		Objects.requireNonNull(lecture);
		this.lectures.add(lecture);
	}
	
	
	

}
