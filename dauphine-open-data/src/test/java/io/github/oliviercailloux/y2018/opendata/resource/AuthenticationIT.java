package io.github.oliviercailloux.y2018.opendata.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.oliviercailloux.y2018.opendata.AbstractArquillianIT;
import io.github.oliviercailloux.y2018.opendata.DauphineOpenDataApp;
import io.github.oliviercailloux.y2018.opendata.cas.Credentials;
import io.github.oliviercailloux.y2018.opendata.cas.DauphineCas;
import io.github.oliviercailloux.y2018.opendata.cas.TestDauphineCas;

public class AuthenticationIT extends AbstractArquillianIT {
	
	@Test
	@RunAsClient
	public void authenticate(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials(TestDauphineCas.TEST_USERNAME, TestDauphineCas.TEST_PASSWORD)));
		assertEquals(200, response.getStatus());
		assertTrue(response.getMediaType().isCompatible(MediaType.TEXT_PLAIN_TYPE));
		assertEquals(TestDauphineCas.TEST_TOKEN, response.readEntity(String.class));
	}
	
	@Test
	@RunAsClient
	public void wrongPassword(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials(TestDauphineCas.TEST_USERNAME, "wrong-password")));
		assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
	}
	
	@Test
	@RunAsClient
	public void wrongCredentialsFormat(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials(TestDauphineCas.TEST_USERNAME, null)));
		assertTrue(response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
	
	@Test
	@RunAsClient
	public void secureAccess(@ArquillianResteasyResource("person") final WebTarget endpoint) {
		Response response = endpoint.request()
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + TestDauphineCas.TEST_TOKEN)
				.get();
		assertTrue(response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	@Test
	@RunAsClient
	public void invalidToken(@ArquillianResteasyResource("person") final WebTarget endpoint) {
		Response response = endpoint.request()
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + "wrong-token")
				.get();
		assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
		assertNotNull(response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE));
	}
	
    @Test
    @RunAsClient
    public void missingToken(@ArquillianResteasyResource("person") final WebTarget endpoint) {
        Response response = endpoint.request()
                .get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
        assertNotNull(response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE));
    }
    
    @Test
    @RunAsClient
    public void whoAmI(@ArquillianResteasyResource("authentication/whoami") final WebTarget endpoint) {
        Response response = endpoint.request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + TestDauphineCas.TEST_TOKEN).get();
        assertEquals(200, response.getStatus());
        assertTrue(response.getMediaType().isCompatible(MediaType.TEXT_PLAIN_TYPE));
        assertEquals(TestDauphineCas.TEST_USERNAME, response.readEntity(String.class));
    }
    
    @Test
    @RunAsClient
    public void iAmNobody(@ArquillianResteasyResource("authentication/whoami") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
        assertNotNull(response.getHeaderString(HttpHeaders.WWW_AUTHENTICATE));
    }
}