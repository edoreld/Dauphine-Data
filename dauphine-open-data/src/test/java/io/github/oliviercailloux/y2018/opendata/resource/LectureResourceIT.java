package io.github.oliviercailloux.y2018.opendata.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.GenericType;

import org.junit.Ignore;

import io.github.oliviercailloux.y2018.opendata.dao.LectureDao;
import io.github.oliviercailloux.y2018.opendata.entity.Lecture;

@Ignore
public class LectureResourceIT extends AbstractResourceIT<Lecture, LectureDao> {

	@Inject
	private LectureDao dao;

	public LectureResourceIT() {
		super("lecture");
	}

	@Override
	protected LectureDao getDao() {
		return dao;
	}

	@Override
	protected GenericType<List<Lecture>> getEntitiesType() {
		return new GenericType<List<Lecture>>() {
		};
	}

	@Override
	protected Lecture makeEntity() {
		final Lecture c = new Lecture();

		return c;
	}

}
