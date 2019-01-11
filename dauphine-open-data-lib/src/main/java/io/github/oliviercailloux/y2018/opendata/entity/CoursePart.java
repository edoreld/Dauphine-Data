package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Preconditions;

/**
 *
 * Represents part of a course. For example, a course can be composed of 30
 * hours of TD and 6 hours of TP. Each of these pairs is a course part.
 *
 * @author Javier Martínez
 *
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CoursePart extends AbstractEntity {

	private static final long serialVersionUID = -6829937183172871605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long coursePartId;

	@NotNull
	@XmlElement
	private CourseTypeEnum courseType;

	@NotNull
	@XmlElement
	private Long globalVolume;

	@XmlElementWrapper
	@XmlElement
	@ManyToMany(mappedBy = "courseParts")
	private Set<Course> courses = new HashSet<>();

	@Override
	public Long getId() {
		return coursePartId;
	}

	/**
	 *
	 * @return the teaching type: TD, TP, etc...
	 */
	public CourseTypeEnum getCourseType() {
		return courseType;
	}

	/**
	 * Sets the teaching type
	 *
	 * @param teachingType
	 */
	public void setCourseType(@NotNull CourseTypeEnum teachingType) {
		Preconditions.checkNotNull(teachingType, "teachingType");
		this.courseType = teachingType;
	}

	/**
	 * @return the global hourly volume of the {@link CoursePart}
	 */
	public Long getGlobalVolume() {
		return globalVolume;
	}

	/**
	 * Sets the global volume of this {@link CoursePart}
	 *
	 * @param globalVolume
	 */
	public void setGlobalVolume(@NotNull Long globalVolume) {
		Preconditions.checkNotNull(globalVolume, "globalVolume");
		this.globalVolume = globalVolume;
	}

	/**
	 * Gets the list of {@link Course} to which this {@link CoursePart} belongs
	 *
	 * @return
	 */
	public Set<Course> getCourses() {
		return new HashSet<>(courses);
	}

	/**
	 * sets the set of courses
	 *
	 * @param courses
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * This enumerate class provide us a list of course types as TD, CM, etc
	 *
	 */
	public enum CourseTypeEnum {
		TP, CM, TD, HOME_WORK, PROFESS_TRAINING, TRAININGWEEKS, ALL
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
