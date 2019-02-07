package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Preconditions;

/**
 *
 * Represents part of a course. For example, a course can be composed of 30
 * hours of TD and 6 hours of TP. Each of these pairs is a course part.
 *
 * This is based on the CDM-fr schema, but only represents a part of it.
 *
 * @author Javier Martínez
 *
 * @version 1.0
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
	private Long id;

	@NotNull
	@XmlElement
	private CourseTypeEnum courseType;

	@NotNull
	@XmlElement
	private Long globalVolume;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	@XmlElement
	private Course course;

	/**
	 * List of {@link Course} types as TD, CM, etc
	 *
	 */
	public enum CourseTypeEnum {
		TP, CM, TD, HOME_WORK, PROFESS_TRAINING, TRAININGWEEKS, ALL
	}

	/**
	 * Returns the internal ID
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 *
	 * @return the teaching type: TD, TP, etc...
	 * @since 1.0
	 */
	public CourseTypeEnum getCourseType() {
		return courseType;
	}

	/**
	 * Sets the teaching type
	 *
	 * @param teachingType
	 * @since 1.0
	 */
	public void setCourseType(@NotNull CourseTypeEnum teachingType) {
		Preconditions.checkNotNull(teachingType, "teachingType");
		this.courseType = teachingType;
	}

	/**
	 * @return the global hourly volume
	 * @since 1.0
	 */
	public Long getGlobalVolume() {
		return globalVolume;
	}

	/**
	 * Sets the global hourly volume
	 *
	 * @param globalVolume
	 * @since 1.0
	 */
	public void setGlobalVolume(@NotNull Long globalVolume) {
		Preconditions.checkNotNull(globalVolume, "globalVolume");
		this.globalVolume = globalVolume;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
