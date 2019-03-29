package io.github.oliviercailloux.y2018.opendata.dao;

public class EntityDoesNotExistDaoException extends DaoException {

	private static final long serialVersionUID = -6741231667108884041L;

	public EntityDoesNotExistDaoException() {
		super();
	}

	public EntityDoesNotExistDaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityDoesNotExistDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityDoesNotExistDaoException(String message) {
		super(message);
	}

	public EntityDoesNotExistDaoException(Throwable cause) {
		super(cause);
	}

}
