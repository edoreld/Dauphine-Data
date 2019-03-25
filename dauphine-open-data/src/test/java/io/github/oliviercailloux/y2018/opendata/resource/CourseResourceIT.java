package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;

import org.junit.Ignore;

import io.github.oliviercailloux.y2018.opendata.dao.CourseDao;
import io.github.oliviercailloux.y2018.opendata.entity.Course;

@Ignore
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
		};
	}

	@Override
	protected Course makeEntity() {
		final Course c = new Course();
		c.setCourseName("test-name");
		c.setCourseDescription("test-description");
		c.setInstructionLanguage("test-lang");
		c.setCourseID("test-id");
		return c;
	}

}
