package io.github.oliviercailloux.y2018.opendata.resource;

import java.net.URI;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.dao.Dao;
import io.github.oliviercailloux.y2018.opendata.dao.DaoException;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.EntityDoesNotExistDaoException;
import io.github.oliviercailloux.y2018.opendata.entity.Entity;

/**
 * Provides a base implementation for a JAX-RS resource class with a RESTful
 * API.<br />
 * The following request are already implemented :
 * <ul>
 * <li>GET /resource</li>
 * <li>GET /resource/{id}</li>
 * <li>POST /resource</li>
 * <li>PUT /resource/{id}</li>
 * <li>DELETE /resource/{id}</li>
 * </ul>
 * By default, every method produces and consumes JSON and XML.<br />
 *
 * @author Dauphine - CLAUDEL Arnaud
 *
 * @param <E> The entity
 * @param <D> The entity Dao
 */
@RequestScoped
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AbstractResource<E extends Entity, D extends Dao<E>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractResource.class);

	@Inject
	protected D dao;

	/**
	 * The name of the resource, mostly used for logging.
	 */
	protected final String resourceName;

	/**
	 * The path of the resource, used to build a URL.
	 */
	protected final String resourcePath;

	/**
	 *
	 * @param dao          The dao to use
	 * @param resourceName The name of the resource, mostly used for logging
	 * @param resourcePath The path of the resource, used to build a URL
	 */
	public AbstractResource(String resourceName, String resourcePath) {
		this.resourceName = Preconditions.checkNotNull(resourceName, "resourceName");
		this.resourcePath = Preconditions.checkNotNull(resourcePath, "resourcePath");
		// dao and transaction will be set via injection
	}

	/**
	 * Checks whether the field injection worked.
	 *
	 * @throws NullPointerException If a field is null
	 */
	@PostConstruct
	public void checkFieldInitialized() {
		Preconditions.checkNotNull(dao, "dao");
	}

	/**
	 * Makes a 201 - Created response with the location of the resource.<br />
	 * The location is the following : /<tt>resourcePath</tt>/<tt>id</tt>.
	 *
	 * @param id The id of the created resource
	 * @return The created response
	 */
	protected Response makeCreatedResponse(Long id) {
		return Response.created(URI.create("/" + resourcePath + "/" + id)).build();
	}

	/**
	 * Returns all elements of the current resource.
	 *
	 * @return all elements of the current resource
	 * @throws DaoException If thrown by {@link Dao#findAll()}
	 */
	@GET
	public Response get() {
		LOGGER.info("[{}] - finding all entities ..", resourceName);
		return Response.ok(dao.findAll()).build();
	}

	/**
	 * Returns the element of the current resource with the given id.<br />
	 * - NOT_FOUND if the element does not exist.
	 *
	 * @param id The id of the element
	 * @return NOT_FOUND or OK response
	 * @throws DaoException If thrown by {@link Dao#findOne(Long)}
	 */
	@GET
	@Path("{id}")
	public Response get(@PathParam("id") Long id) {
		LOGGER.info("[{}] - finding entity with id [{}] ..", resourceName, id);
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		final Optional<E> entityOpt = dao.findOne(id);
		if (entityOpt.isPresent()) {
			return Response.ok(entityOpt.get()).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates the given element of the current resource.<br />
	 * - CREATED if the creation was successful.<br />
	 * - CONFLICT if the element already exists.
	 *
	 * @param entity The entity to create
	 * @return Either a CREATED or CONFLICT response
	 * @throws DaoException If thrown by {@link Dao#persist(Entity)}
	 */
	@POST
	public Response post(E entity) {
		LOGGER.info("[{}] - creating entity [{}] ..", resourceName, entity);
		try {
			final E persistedEntity = dao.persist(entity);
			return makeCreatedResponse(persistedEntity.getId());
		} catch (final EntityAlreadyExistsDaoException e) {
			LOGGER.info("[{}] - entity [{}] already exist ..", resourceName, entity, e);
			return Response.status(Status.CONFLICT).entity("entity already exists").build();
		}
	}

	/**
	 * Creates or updates the given element of the given id.<br />
	 * - FORBIDDEN if the given element has a different id than the given one.<br />
	 * - CREATED if the creation was successful. Note that a different id may be
	 * used for the creation.<br />
	 * - NO_CONTENT if the merge was successful.<br />
	 *
	 * @param id     The id of the resource to update
	 * @param entity The element to create or merge
	 * @return Either a FORBIDDEN, CREATED or NO_CONTENT response
	 * @throws DaoException If thrown by wither {@link Dao#findOne(Long)} or
	 *                      {@link Dao#merge(Entity)}
	 */
	@PUT
	@Path("{id}")
	public Response put(@PathParam("id") Long id, E entity) {
		LOGGER.info("[{}] - merging entity with id [{}] ..", resourceName, id);
		if (entity.getId() == null) {
			LOGGER.warn("[{}] - the provided id is null, creation not allowed", resourceName);
			return Response.status(Status.FORBIDDEN).build();
		}

		if (!id.equals(entity.getId())) {
			LOGGER.warn("[{}] - the provided id [{}] is different than the url one [{}]", resourceName, entity.getId(),
					id);
			return Response.status(Status.FORBIDDEN).build();
		}

		if (!dao.findOne(id).isPresent()) {
			LOGGER.info("[{}] - entity does not exist", resourceName);
			return Response.status(Status.NOT_FOUND).build();
		} else {
			dao.merge(entity);
			return Response.noContent().build();
		}
	}

	/**
	 * Deletes the element with the given id.<br />
	 * - NOT_FOUND if the element does not exist.<br />
	 * - NO_CONTENT if the deletion was successful.<br />
	 *
	 * @param id The id of the element to remove
	 * @return Either a BAD_REQUEST, NOT_FOUND or NO_CONTENT response.
	 * @throws DaoException If thrown by {@link Dao#remove(Long)}
	 */
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		LOGGER.info("[{}] - removing entity with id [{}] ..", resourceName, id);
		try {
			dao.remove(id);
			return Response.noContent().build();
		} catch (final EntityDoesNotExistDaoException e) {
			LOGGER.info("[{}] - removal failed, entity [{}] does not exist", resourceName, id, e);
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
