package io.github.oliviercailloux.y2018.opendata.dao;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.y2018.opendata.entity.Course;

@RequestScoped
public class CourseDao extends AbstractDao<Course> {

	public CourseDao() {
		super("Course", Course.class);
	}

}
