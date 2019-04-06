package io.github.oliviercailloux.y2018.opendata.resource;

import static io.github.oliviercailloux.y2018.opendata.resource.Utils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.github.oliviercailloux.y2018.opendata.cas.DauphineCas;
import io.github.oliviercailloux.y2018.opendata.cas.TestDauphineCas;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.ArquillianUtils;
import io.github.oliviercailloux.y2018.opendata.dao.Dao;
import io.github.oliviercailloux.y2018.opendata.dao.DaoException;
import io.github.oliviercailloux.y2018.opendata.entity.Planning;

@RunWith(Arquillian.class)
public abstract class AbstractResourceIT<E extends io.github.oliviercailloux.y2018.opendata.entity.Entity, D extends Dao<E>> {

	protected static final AtomicLong INC = new AtomicLong(100_000L);
	protected static final String WAR_NAME = "resource-it-war";

	@ArquillianResource
	private URL url;

	private URI uri;

	protected final Client client;
	protected final String resourcePath;

	public AbstractResourceIT(final Client client, final String resourcePath) {
		this.client = Preconditions.checkNotNull(client);
		this.resourcePath = Preconditions.checkNotNull(resourcePath);
	}

	public AbstractResourceIT(final String resourcePath) {
		this(ResteasyClientBuilder.newClient(), resourcePath);
	}

	@Deployment
	public static WebArchive makeWar() {
		return ArquillianUtils.makeWar(WAR_NAME);
	}

	protected abstract D getDao();

	@Before
	public void before() throws URISyntaxException {
		Preconditions.checkNotNull("url", url);
		this.uri = url.toURI();
	}

	@After
	public void after() {
		client.close();
	}

	protected abstract GenericType<List<E>> getEntitiesType();

	protected WebTarget getWebTarget() {
		return client.target(uri);
	}

	protected WebTarget getResourceWebTarget() {
		return getWebTarget().path(resourcePath);
	}

	protected WebTarget getResourceWebTarget(final String path) {
		return getResourceWebTarget().path(path);
	}

	protected WebTarget getWebTarget(final String path) {
		return getWebTarget().path(path);
	}

	protected Builder sendJsonAcceptJsonUTF8English(final String path, final String token) {
		final Builder builder = getResourceWebTarget(path).request();
		sendToken(token, builder);
		sendJson(builder);
		acceptEnglish(builder);
		acceptJson(builder);
		acceptUTF8(builder);
		return builder;
	}
	
	protected Builder sendJsonAcceptJsonUTF8English(final String path) {
		return sendJsonAcceptJsonUTF8English(path, TestDauphineCas.ADMIN_TOKEN);
	}
	
	protected Builder sendJsonAcceptJsonUTF8English() {
		return sendJsonAcceptJsonUTF8English("");
	}

	protected abstract E makeEntity();

	@Test
	public void testGet() throws Exception {
		getDao().persist(makeEntity());
		final List<E> entities = getDao().findAll();
		final Response response = sendJsonAcceptJsonUTF8English().get();
		assertStatusIsOk(response);
		assertContentTypeIsJsonUTF8(response);
		response.bufferEntity();
		final GenericType<List<E>> entitiesType = getEntitiesType();
		final List<E> receivedEntities = response.readEntity(entitiesType);
		assertEquals(receivedEntities, entities);
	}

	@Test
	public void testGetId() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		final Response response = sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString()).get();
		assertStatusIsOk(response);
		assertContentTypeIsJsonUTF8(response);
		assertEntityIs(persistedEntity, response);
	}

	@Test
	public void testGetIdBadRequest() throws IOException, DaoException {
		final Response response = sendJsonAcceptJsonUTF8English("abc").get();
		assertStatusIsNotFound(response);
	}

	@Test
	public void testGetIdNotFound() throws IOException, DaoException {
		final Response response = sendJsonAcceptJsonUTF8English("123456789").get();
		assertStatusIsNotFound(response);
	}

	@Test
	public void testPostAlreadyExists() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		final Response response = sendJsonAcceptJsonUTF8English().post(Entity.json(persistedEntity));
		assertStatusCodeIs(Status.CONFLICT.getStatusCode(), response);
	}
	
	@Test
	public void testGetIsAllowedToAll() {
		assertStatusCodeIs(Status.OK.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.STUDENT_TOKEN).get());
		assertStatusCodeIs(Status.OK.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.TEACHER_TOKEN).get());
		assertStatusCodeIs(Status.OK.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.ADMIN_TOKEN).get());
	}
	
	@Test
	public void testGetIdIsAllowedToAll() {
		assertStatusCodeIs(Status.NOT_FOUND.getStatusCode(), sendJsonAcceptJsonUTF8English("546545", TestDauphineCas.STUDENT_TOKEN).get());
		assertStatusCodeIs(Status.NOT_FOUND.getStatusCode(), sendJsonAcceptJsonUTF8English("44564", TestDauphineCas.TEACHER_TOKEN).get());
		assertStatusCodeIs(Status.NOT_FOUND.getStatusCode(), sendJsonAcceptJsonUTF8English("564564", TestDauphineCas.ADMIN_TOKEN).get());
	}
	
	@Test
	public void testPostIsReservedToAdmin() {
		final E c = makeEntity();
		assertStatusCodeIs(Status.FORBIDDEN.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.STUDENT_TOKEN).post(Entity.json(c)));
		assertStatusCodeIs(Status.FORBIDDEN.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.TEACHER_TOKEN).post(Entity.json(c)));
		assertStatusCodeIs(Status.CREATED.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.ADMIN_TOKEN).post(Entity.json(c)));
	}
	
	@Test
	public void testPutIsReservedToAdminAndTeacher() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		assertStatusCodeIs(Status.FORBIDDEN.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.STUDENT_TOKEN).put(Entity.json(persistedEntity)));
		assertStatusCodeIs(Status.NO_CONTENT.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.TEACHER_TOKEN).put(Entity.json(persistedEntity)));
		assertStatusCodeIs(Status.NO_CONTENT.getStatusCode(), sendJsonAcceptJsonUTF8English("", TestDauphineCas.ADMIN_TOKEN).put(Entity.json(persistedEntity)));
	}
	
	@Test
	public void testDeleteIsReservedToAdmin() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		assertStatusCodeIs(Status.FORBIDDEN.getStatusCode(), sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString(), TestDauphineCas.STUDENT_TOKEN).delete());
		assertStatusCodeIs(Status.FORBIDDEN.getStatusCode(), sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString(), TestDauphineCas.TEACHER_TOKEN).delete());
		assertStatusCodeIs(Status.NO_CONTENT.getStatusCode(), sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString(), TestDauphineCas.ADMIN_TOKEN).delete());
	}
	
	@Test
	public void testPutMerge() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		final Response response = sendJsonAcceptJsonUTF8English().put(Entity.json(persistedEntity));
		assertStatusIsNoContent(response);
	}
	
	@Test
	public void testPutCreateNullId() throws Exception {
		final E c = makeEntity();
		final Response response = sendJsonAcceptJsonUTF8English().put(Entity.json(c));
		assertStatusIsCreated(response);
	}
	
	@Test
	public void testPutCreateNonNullId() throws Exception {
		final E c = makeEntity();
		ReflectionTestUtils.setField(c, "id", INC.incrementAndGet());
		final Response response = sendJsonAcceptJsonUTF8English().put(Entity.json(c));
		assertStatusIsCreated(response);
	}

	@Test
	public void testDelete() throws Exception {
		final E c = makeEntity();
		final E persistedEntity = getDao().persist(c);
		final Response response = sendJsonAcceptJsonUTF8English(persistedEntity.getId().toString()).delete();
		assertStatusIsNoContent(response);
		assertFalse("entity was not removed", getDao().findOne(persistedEntity.getId()).isPresent());
	}

	@Test
	public void testDeleteNotExisting() throws DaoException {
		final Response response = sendJsonAcceptJsonUTF8English("-1").delete();
		assertStatusIsNotFound(response);
	}
	
	public static void main(String[] args) {
		assertEquals(new Planning(1L, "test-name", new ArrayList<>()), new Planning(1L, "test-name", new ArrayList<>()));
		System.out.println("ok");
	}

}
