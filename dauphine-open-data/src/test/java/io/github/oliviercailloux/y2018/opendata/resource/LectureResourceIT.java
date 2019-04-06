package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.GenericType;
import com.diffplug.common.base.Errors;
import io.github.oliviercailloux.y2018.opendata.dao.CourseDao;
import io.github.oliviercailloux.y2018.opendata.dao.LectureDao;
import io.github.oliviercailloux.y2018.opendata.entity.Course;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;


public class LectureResourceIT extends AbstractResourceIT<Lecture, LectureDao> {

	@Inject
	private LectureDao lectureDao;
	
	@Inject
	private CourseDao courseDao;

	public LectureResourceIT() {
		super("lecture");
	}

	@Override
	protected LectureDao getDao() {
		return lectureDao;
	}

	@Override
	protected GenericType<List<Lecture>> getEntitiesType() {
		return new GenericType<List<Lecture>>() {
		};
	}
	
	private Course makePersistedCourse() {
		final Course c = new Course();
		c.setCourseID("test-id");
		c.setCourseName("test-name");
		c.setCourseDescription("test-description");
		c.setInstructionLanguage("test-lang");
		return Errors.rethrow().wrap(() -> courseDao.persist(c)).get();
	}

	@Override
	protected Lecture makeEntity() {
		return new Lecture(makePersistedCourse(), new Date(), 30, "test-group");
	}

}
