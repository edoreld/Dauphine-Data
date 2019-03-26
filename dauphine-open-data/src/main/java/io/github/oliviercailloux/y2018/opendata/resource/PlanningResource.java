package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.Path;

import io.github.oliviercailloux.y2018.opendata.dao.PlanningDao;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;

@Path("planning")
public class PlanningResource extends AbstractResource<Planning, PlanningDao> {

	public PlanningResource() {
		super("Planning", "planning");
	}

}
