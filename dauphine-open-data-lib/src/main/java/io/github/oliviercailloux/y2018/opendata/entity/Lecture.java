package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
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
	@ManyToOne(optional = false)
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
	@ManyToOne(optional = true)
	@XmlElement
	private Person teacher;
	
	@Override
	public Long getId() {
		return id;
	}

}
