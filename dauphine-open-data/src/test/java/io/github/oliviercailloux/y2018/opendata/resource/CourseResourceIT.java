package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;

import org.junit.Ignore;

import io.github.oliviercailloux.y2018.opendata.dao.CourseDao;
import io.github.oliviercailloux.y2018.opendata.entity.Course;

public class CourseResourceIT extends AbstractResourceIT<Course, CourseDao> {

	@Inject
	private CourseDao dao;

	public CourseResourceIT() {
		super("course");
	}

	@Override
	protected CourseDao getDao() {
		return dao;
	}

	@Override
	protected GenericType<List<Course>> getEntitiesType() {
		return new GenericType<List<Course>>() {
			// no implementation required
		};
	}

	@Override
	protected Course makeEntity() {
		return new Course("test-id", "test-name", "test-description", "test-lang");
	}

}
