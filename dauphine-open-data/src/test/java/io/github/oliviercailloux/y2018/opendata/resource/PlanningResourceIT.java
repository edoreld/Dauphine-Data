package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;

import org.junit.Ignore;

import io.github.oliviercailloux.y2018.opendata.dao.PlanningDao;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;

@Ignore
public class PlanningResourceIT extends AbstractResourceIT<Planning, PlanningDao> {

	@Inject
	private PlanningDao dao;

	public PlanningResourceIT() {
		super("planning");
	}

	@Override
	protected PlanningDao getDao() {
		return dao;
	}

	@Override
	protected GenericType<List<Planning>> getEntitiesType() {
		return new GenericType<List<Planning>>() {
		};
	}

	@Override
	protected Planning makeEntity() {
		final Planning c = new Planning("test-name");
		return c;
	}

}
