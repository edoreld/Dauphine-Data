package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import io.github.oliviercailloux.y2018.opendata.entity.Course;

@RequestScoped
public class CourseDao extends AbstractDao<Course> {

	public CourseDao() {
		super("Course", Course.class);
	}

	@SuppressWarnings("unchecked")
	public List<Course> findByNameDescLang(String name, String desc, String lang) {
		if (name.isEmpty() && desc.isEmpty() && lang.isEmpty()) {
			return Collections.EMPTY_LIST;
		}

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Course> q = cb.createQuery(Course.class);
		Root<Course> c = q.from(Course.class); // ~eq to FROM

		if (!name.isEmpty()) {
			q.where(cb.equal(c.get("courseName"), name));
		}
		if (!name.isEmpty()) {
			q.where(cb.equal(c.get("courseDescription"), name));
		}
		if (!name.isEmpty()) {
			q.where(cb.equal(c.get("instructionLanguage"), name));
		}

		TypedQuery<Course> query = em.createQuery(q);
		return query.getResultList();
	}

}
