package io.github.oliviercailloux.y2018.opendata.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import io.github.oliviercailloux.y2018.opendata.entity.Course;

/**
 *
 * @author edoreld
 *
 */
public class CourseDao extends AbstractDao<Course> {

	/**
	 * This constructor expects both managed entity manager.
	 *
	 * @param entityManager A managed entity manager
	 */
	public CourseDao(final EntityManager entityManager) {
		super(entityManager, Course.class, "Course");
	}

	/**
	 * @since 1.0
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
		return query.getResultList();
	}

	/**
	 * @since 1.0
	 */
	@Override
	public Optional<Course> findOne(Long id) {
		return Optional.of(entityManager.find(entityClass, id));
	}

	/**
	 * @since 1.0
	 */
	@Override
	public Course persist(Course entity) throws EntityAlreadyExistsDaoException {
		if (!entityManager.contains(entity))
			entityManager.persist(entity);
		return entity;
	}

	/**
	 * @since 1.0
	 */
	@Override
	public Course merge(Course entity) {
		return entityManager.merge(entity);
	}

	/**
	 * @since 1.0
	 */
	@Override
	public void remove(Long id) throws EntityDoesNotExistDaoException {
		Course course = entityManager.find(entityClass, id);
		if (course != null)
			entityManager.remove(course);
	}
}
