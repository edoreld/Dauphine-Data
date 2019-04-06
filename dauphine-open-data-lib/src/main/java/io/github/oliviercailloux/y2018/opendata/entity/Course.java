package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.EnumMap;
import java.util.Map;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents a Dauphine Course. It's meant to be a subset of the CDM-fr schema.
 *
 * @author Javier Martínez
 * @version 1.1
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Course implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	public enum CoursePart {
		CM, TP, TD, HOMEWORK, PROFESSTRAINING, TRAININGWEEKS, ALL
	}
	
	private static final long serialVersionUID = -6829937183172871605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	@Unique
	private String courseID;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String courseName;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String courseDescription;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String instructionLanguage;

	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Course_Part")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "type", nullable = false)
	@XmlElementWrapper
	@XmlElement
	private Map<CoursePart, Integer> volumes = new EnumMap<>(CoursePart.class);


	
}