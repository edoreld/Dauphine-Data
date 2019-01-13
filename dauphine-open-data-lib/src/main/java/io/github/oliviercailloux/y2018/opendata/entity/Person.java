package io.github.oliviercailloux.y2018.opendata.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

public class Person extends AbstractEntity {

	/**
	 * Implemented by another member of the group
	 * 
	 * I created this empty class because it's referenced in my Planning class, 
	 * 
	 * it must be deleted during the merge
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;
	
	private static final long serialVersionUID = -5865100813791955358L;

	@Override
	public Long getId() {
		return id;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
