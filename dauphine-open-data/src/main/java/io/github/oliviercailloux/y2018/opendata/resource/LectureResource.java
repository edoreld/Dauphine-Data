package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.Path;

import io.github.oliviercailloux.y2018.opendata.dao.LectureDao;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@Path("lecture")
public class LectureResource extends AbstractResource<Lecture, LectureDao> {

	public LectureResource() {
		super("Lecture", "lecture");
	}

}
