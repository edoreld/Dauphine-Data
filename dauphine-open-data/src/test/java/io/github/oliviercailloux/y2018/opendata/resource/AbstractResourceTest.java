package io.github.oliviercailloux.y2018.opendata.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.collect.ImmutableList;

import io.github.oliviercailloux.y2018.opendata.dao.Dao;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.EntityDoesNotExistDaoException;
import io.github.oliviercailloux.y2018.opendata.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RunWith(MockitoJUnitRunner.class)
public class AbstractResourceTest {

	private static final AtomicLong INC = new AtomicLong();

	@Mock
	private Dao<FakeEntity> dao;

	private final FakeResource resource = new FakeResource();

	@Before
	public void before() {
		ReflectionTestUtils.setField(resource, "dao", dao);
	}

	private FakeEntity makeFakeEntity() {
		final Long id = INC.incrementAndGet();
		return new FakeEntity(id, id + "-name");
	}
	
	private FakeEntity makeFakeEntityNullId() {
		final Long id = INC.incrementAndGet();
		return new FakeEntity(null, id + "-name");
	}

	private void assertResponseOK(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_OK, response.getStatus());
	}

	private void assertResponseNotFound(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_NOT_FOUND, response.getStatus());
	}

	private void assertResponseBadRequest(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_BAD_REQUEST, response.getStatus());
	}

	@Test
	public void testCheckFieldInitialized() {
		resource.checkFieldInitialized();
		assertNotNull(ReflectionTestUtils.getField(resource, "dao"));
	}

	@Test
	public void testGet() {
		final List<FakeEntity> entities = ImmutableList.of(makeFakeEntity(), makeFakeEntity());
		given(dao.findAll()).willReturn(entities);
		final Response response = resource.get();
		then(dao).should(Mockito.atLeastOnce()).findAll();
		assertResponseOK(response);
		assertEquals("entity list KO", entities, response.getEntity());
	}

	@Test
	public void testGetIdOk() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.findOne(entity.getId())).willReturn(Optional.of(entity));
		final Response response = resource.get(entity.getId());
		then(dao).should(Mockito.atLeastOnce()).findOne(entity.getId());
		assertResponseOK(response);
		assertEquals("entity KO", entity, response.getEntity());
	}

	@Test
	public void testGetIdNotFound() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.findOne(entity.getId())).willReturn(Optional.empty());
		final Response response = resource.get(entity.getId());
		then(dao).should(Mockito.atLeastOnce()).findOne(entity.getId());
		assertResponseNotFound(response);
		assertNull("entity KO", response.getEntity());
	}

	@Test
	public void testGetIdNull() throws Exception {
		final Response response = resource.get(null);
		then(dao).should(Mockito.never()).findOne(Mockito.any());
		assertResponseBadRequest(response);
		assertNull("entity KO", response.getEntity());
	}

	@Test
	public void testPostCreated() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.persist(entity)).willReturn(entity);
		final Response response = resource.post(entity);
		then(dao).should(Mockito.atLeastOnce()).persist(entity);
		assertResponseCreated(response);
		assertNotNull("entity location KO", response.getLocation());
		assertTrue("entity location KO", response.getLocation().toString().contains(entity.getId().toString()));
	}

	@Test
	public void testPostConflict() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.persist(entity)).willThrow(new EntityAlreadyExistsDaoException());
		final Response response = resource.post(entity);
		then(dao).should(Mockito.atLeastOnce()).persist(entity);
		assertResponseConflict(response);
	}

	private void assertResponseConflict(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_CONFLICT, response.getStatus());
	}

	private void assertResponseCreated(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_CREATED, response.getStatus());
	}

	@Test
	public void testPutMerge() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.findOne(entity.getId())).willReturn(Optional.of(entity));
		given(dao.merge(entity)).willReturn(entity);
		final Response response = resource.put(entity);
		then(dao).should(Mockito.atLeastOnce()).merge(entity);
		then(dao).should(Mockito.atLeastOnce()).findOne(Mockito.anyLong());
		assertResponseNoContent(response);
	}
	
	@Test
	public void testPutCreateNullId() throws Exception {
		final FakeEntity entity = makeFakeEntityNullId();
		given(dao.persist(entity)).willReturn(entity);
		final Response response = resource.put(entity);
		then(dao).should(Mockito.never()).findOne(Mockito.anyLong());
		then(dao).should(Mockito.atLeastOnce()).persist(entity);
		assertResponseCreated(response);
	}
	
	@Test
	public void testPutCreateNonNullId() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		given(dao.findOne(entity.getId())).willReturn(Optional.empty());
		given(dao.merge(entity)).willReturn(entity);
		final Response response = resource.put(entity);
		then(dao).should(Mockito.atLeastOnce()).findOne(Mockito.anyLong());
		then(dao).should(Mockito.atLeastOnce()).merge(entity);
		assertResponseCreated(response);
	}
	
	private void assertResponseForbidden(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_FORBIDDEN, response.getStatus());
	}

	@Test
	public void testDeleteOk() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		final Response response = resource.delete(entity.getId());
		then(dao).should(Mockito.atLeastOnce()).remove(entity.getId());
		assertResponseNoContent(response);
	}

	private void assertResponseNoContent(final Response response) {
		assertEquals("status code KO", HttpServletResponse.SC_NO_CONTENT, response.getStatus());
	}

	@Test
	public void testDeleteNotFound() throws Exception {
		final FakeEntity entity = makeFakeEntity();
		Mockito.doThrow(EntityDoesNotExistDaoException.class).when(dao).remove(entity.getId());
		final Response response = resource.delete(entity.getId());
		then(dao).should(Mockito.atLeastOnce()).remove(entity.getId());
		assertResponseNotFound(response);
	}

}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
class FakeEntity implements Entity {

	@Nullable
	private Long id;

	@NotNull
	private String name;

	@Override
	public Long getId() {
		return id;
	}

}

class FakeResource extends AbstractResource<FakeEntity, Dao<FakeEntity>> {

	public FakeResource() {
		super("FakeEntity", "fakeEntity");
	}

}