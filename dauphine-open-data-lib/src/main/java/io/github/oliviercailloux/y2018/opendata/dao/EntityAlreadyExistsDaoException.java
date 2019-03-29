package io.github.oliviercailloux.y2018.opendata.dao;

public class EntityAlreadyExistsDaoException extends DaoException {

	private static final long serialVersionUID = -6741231667108884041L;

	public EntityAlreadyExistsDaoException() {
		super();
	}
	public EntityAlreadyExistsDaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityAlreadyExistsDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityAlreadyExistsDaoException(String message) {
		super(message);
	}

	public EntityAlreadyExistsDaoException(Throwable cause) {
		super(cause);
	}

}
