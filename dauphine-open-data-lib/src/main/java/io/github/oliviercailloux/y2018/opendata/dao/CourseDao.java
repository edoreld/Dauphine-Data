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

	/**
	 * Returns the list of courses that match the parameters passed by argument
	 *
	 * We work with the assumption that someone using our program is trying to find data with non-empty fields.
	 * If a parameter is empty, it's not used in the SQL query.
	 * Therefore, if all parameters are empty, no results are returned
	 *
	 * The search works like SQL LIKE. If a course is named "Java", it will be returned
	 * whether the query is "Java", "Javaa" or "aJava". On the other hand, "Jva", "Jaa" or "Jvaa" won't be returned.
	 *
	 * @param name
	 * @param desc
	 * @param lang
	 * @return
	 */

	public List<Course> findByNameDescLang(String name, String desc, String lang) {
		if (name.isEmpty() && desc.isEmpty() && lang.isEmpty()) {
			return Collections.emptyList();
		}

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Course> q = cb.createQuery(Course.class);
		Root<Course> c = q.from(Course.class); // similar to FROM

		if (!name.isEmpty()) {
			q.where(cb.like(c.<String>get("courseName"), "%" + name + "%"));
		}
		if (!desc.isEmpty()) {
			q.where(cb.like(c.<String>get("courseDescription"), "%" + desc + "%"));
		}
		if (!lang.isEmpty()) {
			q.where(cb.like(c.<String>get("instructionLanguage"), "%" + lang + "%"));
		}

		TypedQuery<Course> query = em.createQuery(q);
		return query.getResultList();
	}

}
