package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 *
 * Represents a Dauphine Course. It's meant to be a subset of the CDM-fr schema.
 *
 * @author Javier Martínez
 *
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course extends AbstractEntity {

	private static final long serialVersionUID = -6829937183172871605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@XmlElement
	@Unique
	private String courseID;

	@Column(nullable = false)
	@XmlElement
	private String courseName;

	@Column(nullable = false)
	@XmlElement
	private String courseDescription;

	@Column(nullable = false)
	@XmlElement
	private String instructionLanguage;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	@XmlElementWrapper
	@XmlElement
	private Set<CoursePart> courseParts = new HashSet<>();

	/**
	 * Returns the business id of the course
	 *
	 * @since 1.0
	 */

	@Override
	public Long getId() {
		return id;
	}

	/*
	 * Returns the external id of the course, such as the ones on the ROF xml.
	 *
	 * @since 1.0
	 */
	public String getCourseID() {

		return courseID;
	}

	/**
	 * Sets the external {@code not null} id of the {@link Course}
	 *
	 * @param courseID
	 * @since 1.0
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the name of the course
	 * @since 1.0
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the {@code not null} name of the {@link Course}
	 *
	 * @param courseName
	 * @since 1.0
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the {@code not null} description of the course
	 * @since 1.0
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/**
	 * Sets the {@code not null} description of the {@link Course}
	 *
	 * @param courseDescription
	 * @since 1.0
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/**
	 *
	 * @return a list of the parts of the course @
	 */
	public Set<CoursePart> getCourseParts() {
		return new HashSet<>(courseParts);
	}

	/**
	 * Add a coursePart to the coursePart list
	 *
	 * @param coursepart
	 * @since 1.0
	 */
	public void addCoursePart(CoursePart coursePart) {
		this.courseParts.add(coursePart);
	}

	/**
	 * Remove a coursePart from the coursePart list
	 *
	 * @param coursePart
	 */
	public void removeCoursePart(CoursePart coursePart) {
		this.courseParts.remove(coursePart);
	}

	/**
	 * Returns the language of the course
	 *
	 * @return instructionLanguage
	 * @since 1.1
	 */
	public String getInstructionLanguage() {
		return instructionLanguage;
	}

	/**
	 * Sets the language of the {@code not null} {@link Course}
	 *
	 * @param instructionLanguage
	 * @since 1.1
	 *
	 */
	public void setInstructionLanguage(String instructionLanguage) {
		this.instructionLanguage = instructionLanguage;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this, obj);
	}
}
