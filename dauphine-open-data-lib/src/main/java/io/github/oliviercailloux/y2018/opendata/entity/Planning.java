package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * Here is a basic implementation for the class Planning
 *
 * Planning concerns all the courses of a person in particular a teacher over a
 * given period of time As there is a need for persistence, we have considered
 * it as an entity
 *
 * @author elhadj diallo
 *
 */

@Entity
@NoArgsConstructor
@RequiredArgsConstructor	
@AllArgsConstructor
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Planning implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	private static final long serialVersionUID = -5050839598082807501L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@NonNull
	@Column(nullable = false)
	@XmlElement
	private String name;

	@NonNull
	@ManyToMany(fetch = FetchType.EAGER)
	@XmlElementWrapper(name = "lectures")
	@XmlElement(name = "lecture")
	private List<Lecture> lectures = new ArrayList<>();
	
}
