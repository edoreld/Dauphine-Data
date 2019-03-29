package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.Path;

import io.github.oliviercailloux.y2018.opendata.dao.CourseDao;
import io.github.oliviercailloux.y2018.opendata.entity.Course;

@Path("course")
public class CourseResource extends AbstractResource<Course, CourseDao> {

	public CourseResource() {
		super("Course", "course");
	}

}
