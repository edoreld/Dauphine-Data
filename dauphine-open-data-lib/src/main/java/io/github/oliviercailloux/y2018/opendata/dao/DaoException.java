package io.github.oliviercailloux.y2018.opendata.dao;

/**
 * Root of exceptions thrown by {@link Dao} methods.
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 2180204496566733357L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
