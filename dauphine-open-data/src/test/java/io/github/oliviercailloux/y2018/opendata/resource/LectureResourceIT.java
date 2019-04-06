package io.github.oliviercailloux.y2018.opendata.resource;


import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertContentTypeIsJsonUTF8;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertEntityIs;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusCodeIs;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusIsCreated;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusIsNoContent;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusIsOk;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

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
		return c;
	}

	@Override
	protected Lecture makeEntity() {
		return new Lecture(makePersistedCourse(), new Date(), 30,"test-group");
	}

	@Override
	public void testPutMerge() throws Exception {

		Lecture l = makeEntity();
		final Lecture persistedEntity = getDao().persist(l);
		final Response response = sendJsonAcceptJsonUTF8English().put(Entity.json(persistedEntity));
		assertStatusIsNoContent(response);
	}
	
	@Override
	public void testGet() throws Exception {
		
		Lecture l = makeEntity();
		getDao().persist(l);
		final Response response = sendJsonAcceptJsonUTF8English().get();
		assertStatusIsOk(response);
		
	}
	@Override
	public void testGetId() throws Exception {
	    Lecture l=makeEntity();
		final Lecture persistedEntity = getDao().persist(l);
		final Response response = sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString()).get();
		assertStatusIsOk(response);
		assertContentTypeIsJsonUTF8(response);
		assertEntityIs(persistedEntity, response);
	}
	
	@Override
	public void testPostAlreadyExists() throws Exception {
		final Lecture c = makeEntity();
		final Lecture persistedEntity = getDao().persist(c);
		final Response response = sendJsonAcceptJsonUTF8English().post(Entity.json(persistedEntity));
		assertStatusCodeIs(Status.CONFLICT.getStatusCode(), response);
	}
	@Override
	public void testPutCreateNonNullId() throws Exception {
		final Lecture c = makeEntity();
		final Lecture persistedEntity = getDao().persist(c);
		ReflectionTestUtils.setField(c, "id", INC.incrementAndGet());
		final Response response = sendJsonAcceptJsonUTF8English().put(Entity.json(persistedEntity));
		assertStatusIsCreated(response);
	}

}
