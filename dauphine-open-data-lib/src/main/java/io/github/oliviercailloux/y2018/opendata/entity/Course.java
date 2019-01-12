package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.checkerframework.common.aliasing.qual.Unique;

import com.google.common.base.Preconditions;

/**
 *
 * Represents a Dauphine Course
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

	@NotNull
	@XmlElement
	@Unique
	private String courseID;

	@NotNull
	@XmlElement
	private String courseName;

	@NotNull
	@XmlElement
	private String courseDescription;

	@NotNull
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
	public void setCourseID(@NotNull String courseID) {
		Preconditions.checkNotNull(courseID, "courseID");
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
	public void setCourseName(@NotNull String courseName) {
		Preconditions.checkNotNull(courseName, "coursename");
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
	public void setCourseDescription(@NotNull String courseDescription) {
		Preconditions.checkNotNull(courseName, "coursedescription");
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
	 * Sets the list of course parts
	 *
	 * @param coursePartsl
	 */
	public void setCourseParts(Set<CoursePart> courseParts) {
		this.courseParts = courseParts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Returns the language of the course
	 *
	 * @return
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
	public void setInstructionLanguage(@NotNull String instructionLanguage) {
		Preconditions.checkNotNull(instructionLanguage, "instructionLanguage");
		this.instructionLanguage = instructionLanguage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
