package io.github.oliviercailloux.y2018.opendata.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.entity.Entity;

/**
 * Provides a base implementation of the interface {@link Dao}.<br />
 * <br />
 * This implementation uses an {@link EntityManager} to interact with the
 * persistence layer. Only the class and the name of the entity are required to
 * implement all methods.<br />
 * <br />
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 * @param <E> The entity
 */
public abstract class AbstractDao<E extends Entity> implements Dao<E> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);

	protected final EntityManager entityManager;

	/**
	 * The class of the entity, used with the entity manager.
	 */
	protected final Class<E> entityClass;

	/**
	 * The name of entity, should match with the table name since it is used to
	 * build SQL query.
	 */
	protected final String entityName;

	/**
	 * This constructor expects both managed entity manager.
	 *
	 * @param entityManager A managed entity manager
	 * @param entityClass   The class of the entity, used with the entity manager
	 * @param entityName    The name of entity, should match with the table name
	 *                      since it is used to build SQL query
	 */
	public AbstractDao(final EntityManager entityManager, final Class<E> entityClass, final String entityName) {
		this.entityManager = Preconditions.checkNotNull(entityManager, "entityManager");
		this.entityClass   = Preconditions.checkNotNull(entityClass, "entityClass");
		this.entityName    = Preconditions.checkNotNull(entityName, "entityName");
	}

	@Override
	public void flush() {
		LOGGER.info("flushing entity manager ..");
		entityManager.flush();
	}

}
