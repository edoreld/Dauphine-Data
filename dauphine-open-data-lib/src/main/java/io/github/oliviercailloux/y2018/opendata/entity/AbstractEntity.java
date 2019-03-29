package io.github.oliviercailloux.y2018.opendata.entity;

/**
 * Almost empty implementation of {@link Entity} which provides base
 * implementation of the methods {@link #toString()}, {@link #equals(Object)}.
 * and {@link #hashCode()}. <br />
 * implementation of the method {@link #toString()}.<br />
 * This mostly provides a nice flexibility for future features.
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 */
public abstract class AbstractEntity implements Entity {

	private static final long serialVersionUID = 1919019794294704718L;

	@Override
	public String toString() {
		if (getId() == null) {
			return super.toString();
		}

		return getId().toString();
	}
}
