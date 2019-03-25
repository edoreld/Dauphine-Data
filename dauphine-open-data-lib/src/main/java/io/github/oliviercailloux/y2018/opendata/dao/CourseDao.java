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
@Transactional
@RequestScoped
public class CourseDao implements Dao<Course> {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Course> findAll() {
		final Query query = entityManager.createQuery("SELECT c FROM Course c");
		return query.getResultList();
	}

	@Override
	public Optional<Course> findOne(Long id) {
		return Optional.ofNullable(entityManager.find(Course.class, id));
	}

	private boolean courseAlreadyExists(Course course) {
		return course.getId() != null && findOne(course.getId()).isPresent();
	}

	@Override
	public Course persist(Course entity) throws EntityAlreadyExistsDaoException {
		if (courseAlreadyExists(entity)) {
			throw new EntityAlreadyExistsDaoException();
		}
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Course merge(Course entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		final Course course = entityManager.find(Course.class, id);
		if (course == null) {
			throw new EntityDoesNotExistDaoException();
		}
		entityManager.remove(course);
	}

	@Override
	public void flush() {
		entityManager.flush();
	}
}
