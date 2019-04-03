package io.github.oliviercailloux.y2018.opendata.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;

import org.junit.Test;

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

	@Test
	public void testSearch() throws Exception {
		final Course c = makeEntity();
		final Course persistedEntity = getDao().persist(c);

		sendJsonAcceptJsonUTF8English().put(Entity.json(c));
		List<Course> courses = getDao().findByNameDescLang("test-name", "test-description", "test-lang");
		assertEquals(courses.get(0).getCourseName(), "test-name");

	}
}
