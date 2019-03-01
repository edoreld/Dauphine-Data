package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import io.github.oliviercailloux.y2018.opendata.entity.Course;

/**
 *
 * @author Javier Martinez
 *
 */
@RequestScoped
public class CourseDao extends AbstractDao<Course> {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	@Override
	public List<Course> findAll() {
		final Query query = entityManager.createQuery("SELECT c FROM Course c");
		return query.getResultList();
	}

	@Transactional
	@Override
	public Optional<Course> findOne(Long id) {
		return Optional.of(entityManager.find(Course.class, id));
	}

	@Transactional
	@Override
	public Course persist(Course entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Course merge(Course entity) {
		return entityManager.merge(entity);
	}

	@Transactional
	@Override
	public void remove(Long id) {
		final Course course = entityManager.find(Course.class, id);
		if (course != null) {
			entityManager.remove(course);
		}
	}

	@Transactional
	@Override
	public void flush() {
		entityManager.flush();
	}
}
