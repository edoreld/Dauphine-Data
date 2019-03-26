package io.github.oliviercailloux.y2018.opendata.dao;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.y2018.opendata.entity.Planning;

@RequestScoped
public class PlanningDao extends AbstractDao<Planning> {

	public PlanningDao() {
		super("Planning", Planning.class);
	}

}
