package io.github.oliviercailloux.y2018.opendata.resource;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

	public static Builder sendContentType(final String contentType, final Builder builder) {
		builder.header(HttpHeaders.CONTENT_TYPE, contentType);
		return builder;
	}

	public static Builder sendXml(final Builder builder) {
		sendContentType(MediaType.APPLICATION_XML, builder);
		return builder;
	}

	public static Builder sendJson(final Builder builder) {
		sendContentType(MediaType.APPLICATION_JSON, builder);
		return builder;
	}

	public static Builder acceptCharset(final String charset, final Builder builder) {
		builder.header(HttpHeaders.ACCEPT_CHARSET, charset);
		return builder;
	}

	public static Builder acceptUTF8(final Builder builder) {
		return acceptCharset(StandardCharsets.UTF_8.name(), builder);
	}

	public static Builder acceptLanguage(final String language, final Builder builder) {
		builder.header(HttpHeaders.ACCEPT_LANGUAGE, language);
		return builder;
	}

	public static Builder acceptEnglish(final Builder builder) {
		return acceptLanguage(Locale.ENGLISH.getLanguage(), builder);
	}

	public static Builder accept(final String accept, final Builder builder) {
		builder.header(HttpHeaders.ACCEPT, accept);
		return builder;
	}

	public static Builder acceptJson(final Builder builder) {
		return accept(MediaType.APPLICATION_JSON, builder);
	}

	public static Builder acceptXml(final Builder builder) {
		return accept(MediaType.APPLICATION_XML, builder);
	}

	public static InputStream getInputStream(final Response response) {
		return (InputStream) response.getEntity();
	}

	public static Scanner getScanner(final Response response) throws IOException {
		return new Scanner(new BufferedInputStream(getInputStream(response)));
	}

	public static <T extends io.github.oliviercailloux.y2018.opendata.entity.Entity> T getEntity(final Response response,
			final Class<T> entityType) {
		response.bufferEntity();
		return response.readEntity(entityType);
	}

	public static void assertStatusCodeIs(final int expectedStatusCode, final Response response) {
		assertEquals("status code KO", expectedStatusCode, response.getStatus());
	}

	public static void assertStatusIsOk(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_OK, response);
	}

	public static void assertStatusIsNoContent(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_NO_CONTENT, response);
	}

	public static void assertStatusIsNotFound(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_NOT_FOUND, response);
	}

	public static void assertStatusIsForbidden(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_FORBIDDEN, response);
	}

	public static void assertStatusIsBadRequest(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_BAD_REQUEST, response);
	}

	public static void assertStatusIsCreated(final Response response) {
		assertStatusCodeIs(HttpServletResponse.SC_CREATED, response);
	}

	public static void assertContentTypeIs(final String contentType, final Response response) {
		assertEquals("Content-Type KO", contentType, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
	}

	public static void assertContentTypeIsJsonUTF8(final Response response) {
		assertContentTypeIs("application/json; charset=UTF-8", response);
	}

	public static void assertContentTypeIsXmlUTF8(final Response response) {
		assertContentTypeIs("application/xml; charset=UTF-8", response);
	}

	public static void assertBodyIs(final String expectedBody, final Response response) throws IOException {
		assertEquals("Body KO", expectedBody, getScanner(response).nextLine());
	}

	public static <T extends io.github.oliviercailloux.y2018.opendata.entity.Entity> void assertEntityIs(
			final T expectedEntity, final Response response) {
		assertEquals("Entity KO", expectedEntity, getEntity(response, expectedEntity.getClass()));
	}

}
