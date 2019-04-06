package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Taric GANDI This class contain NamedQuaries That help to make easy
 *         request to get information about a person Three fields are chosen to
 *         make request by filtering : {@link Lecture#teacher.lastName}
 *         {@link Lecture#teacher.firstName} {@link Lecture#groupName}
 *         {@link Lecture#room} {@link Lecture#course.courseName}
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@NamedQueries({
		@NamedQuery(name = "FindLectureByGroupName", query = "SELECT l FROM Lecture l WHERE l.groupName  = :gName"),
		@NamedQuery(name = "FindLectureByCourseRoom", query = "SELECT l FROM Lecture l WHERE l.room       = :lcroom"),
		@NamedQuery(name = "FindLectureByTeacherName", query = "SELECT l FROM Lecture l WHERE l.teacher.firstName  "
				+ "= :lfName and l.teacher.lastName  = :llName"),
		@NamedQuery(name = "FindLectureByCourseName", query = "SELECT l FROM Lecture l WHERE l.course.courseName  = :lcName") })

public class Lecture implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	private static final long serialVersionUID = -6829937183172871605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	/**
	 * The associated course
	 */
	@NonNull
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@XmlElement
	private Course course;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private Date date;

	/**
	 * Duration in minutes
	 */
	@NonNull
	@Column(nullable = false)
	@XmlElement
	private Integer duration;

	@XmlElement
	private String room;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String groupName;

	/**
	 * the associated teacher
	 */
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@XmlElement
	private Person teacher;

}
