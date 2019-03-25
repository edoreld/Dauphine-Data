package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Represents a Dauphine Course. It's meant to be a subset of the CDM-fr schema.
 *
 * @author Javier Martínez
 * @version 1.1
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

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

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Course_Part")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "type", nullable = false)
	@XmlElementWrapper
	@XmlElement
	private final Map<CoursePart, Integer> volumes = new EnumMap<>(CoursePart.class);

	public enum CoursePart {
		CM, TP, TD, HOMEWORK, PROFESSTRAINING, TRAININGWEEKS, ALL
	}

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
	 * @return sets the coursePart associated with {@code key} to value
	 *         {@code value}
	 */
	public void setCoursePart(CoursePart key, Integer value) {
		this.volumes.put(key, value);
	}

	/**
	 * Removes the coursepart associated with a {@code key}
	 *
	 * @param key key whose mapping is to be removed from the map
	 * @return the value previously associated with this key
	 */
	public Integer removeCoursePart(CoursePart key) {
		return this.volumes.remove(key);
	}

	/**
	 * Returns a Set view of the mappings contained in this map.
	 *
	 * @return
	 */
	public Set<Map.Entry<CoursePart, Integer>> entrySet() {
		return this.volumes.entrySet();
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
	 */
	public void setInstructionLanguage(String instructionLanguage) {
		this.instructionLanguage = instructionLanguage;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Course)) {
			return false;
		}

		final Course course = (Course) obj;

		return course.getId() == this.getId();
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + id.hashCode();
		return result;
	}
}