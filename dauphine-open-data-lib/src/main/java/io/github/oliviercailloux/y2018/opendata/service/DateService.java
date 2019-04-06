package io.github.oliviercailloux.y2018.opendata.service;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DateService {

	public Date getCurrentDate() {
		return new Date();
	}
	
}
