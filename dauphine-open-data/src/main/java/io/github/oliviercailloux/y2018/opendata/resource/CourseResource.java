package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.oliviercailloux.y2018.opendata.dao.CourseDao;
import io.github.oliviercailloux.y2018.opendata.entity.Course;

@Path("course")
public class CourseResource extends AbstractResource<Course, CourseDao> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseResource.class);

	@PersistenceContext
	protected EntityManager em;

	public CourseResource() {
		super("Course", "course");
	}

	/**
	 * Adds search functionality to courses. Users can search courses by name, description or language.
	 *
	 * An example search URL would be:
	 * <app-root>/course/search?name=java&desc=a nice course
	 * @param lang {@link Course#instructionLanguage}
	 * @param desc {@link Course#courseDescription}
	 * @param name {@link Course#courseName}
	 * @return list of {@link Course} entities that match the query parameters
	 */
	@Path("search")
	@GET
	public Response filter(@DefaultValue("") @QueryParam("name") String name,
			@DefaultValue("") @QueryParam("desc") String desc, @DefaultValue("") @QueryParam("lang") String lang) {

		LOGGER.info("[{}] - finding entities by name [{}], description [{}] and language [{}] ..", resourceName, name,
				desc, lang);
		List<Course> courses = dao.findByNameDescLang(name, desc, lang);
		return Response.ok(courses).build();
	}
}
