package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course extends AbstractEntity {

	private static final long serialVersionUID = -6829937183172871605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseBusinessID;

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
	private String teacher;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Course_CoursePart", joinColumns = {
			@JoinColumn(name = "courseBusinessID") }, inverseJoinColumns = { @JoinColumn(name = "coursePartId") })
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
		return courseBusinessID;
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
	 * Sets the external id of the course
	 *
	 * @param courseID
	 * @since 1.0
	 */
	public void setCourseID(@NotNull String courseID) {
		Preconditions.checkNotNull(courseID, "courseID");
		this.courseID = courseID;
	}

	/**
	 * @return the not null name of the course
	 * @since 1.0
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the name of the course
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
	 * Sets the description of the course
	 *
	 * @param courseDescription
	 * @since 1.0
	 */
	public void setCourseDescription(@NotNull String courseDescription) {
		Preconditions.checkNotNull(courseName, "coursedescription");
		this.courseDescription = courseDescription;
	}

	/**
	 * @return the {@code not null} teacher of the course
	 * @since 1.0
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * Sets the teacher of the course
	 *
	 * @param teacher
	 * @since 1.0
	 */
	public void setTeacher(@NotNull String teacher) {
		Preconditions.checkNotNull(teacher, "teacher");
		this.teacher = teacher;
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

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
