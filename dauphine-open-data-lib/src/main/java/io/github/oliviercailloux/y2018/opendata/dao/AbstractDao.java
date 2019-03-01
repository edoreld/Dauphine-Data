package io.github.oliviercailloux.y2018.opendata.dao;

import io.github.oliviercailloux.y2018.opendata.entity.Entity;

/**
 * Root class of every {@link Dao} implementation of this package.
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 * @param <E> The entity
 */
public abstract class AbstractDao<E extends Entity> implements Dao<E> {
	// may contains additional features later
}
