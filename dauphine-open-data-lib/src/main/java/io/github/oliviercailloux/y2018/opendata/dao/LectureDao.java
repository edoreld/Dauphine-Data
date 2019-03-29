package io.github.oliviercailloux.y2018.opendata.dao;

import javax.enterprise.context.RequestScoped;

import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@RequestScoped
public class LectureDao extends AbstractDao<Lecture> {

	public LectureDao() {
		super("Lecture", Lecture.class);
	}

}