package io.github.oliviercailloux.y2018.opendata.resource;

import io.github.oliviercailloux.y2018.opendata.DauphineOpenDataApp;
import io.github.oliviercailloux.y2018.opendata.cas.Credentials;
import io.github.oliviercailloux.y2018.opendata.cas.DauphineCas;
import io.github.oliviercailloux.y2018.opendata.cas.FakeDauphineCas;
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

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class AuthenticationIT {

	@Deployment
	public static WebArchive makeWar() {
		
		final File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();
		
		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "io.github.oliviercailloux.y2018.opendata")
				.addClass(DauphineOpenDataApp.class).addAsResource("arquillian.xml")
				.deleteClass(FakeDauphineCas.class);
		
		return ShrinkWrap.create(WebArchive.class)
				.addAsLibraries(libs)
				.addAsLibrary(jar)
				.addAsResource("META-INF/persistence.xml");
	}
	
	@Test
	@RunAsClient
	public void authenticate(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials("user", "password")));
		assertEquals(200, response.getStatus());
		assertTrue(response.getMediaType().isCompatible(MediaType.TEXT_PLAIN_TYPE));
		assertEquals("test-token", response.readEntity(String.class));
	}
	
	@Test
	@RunAsClient
	public void wrongPassword(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials("user", "wrong-password")));
		assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
	}
	
	@Test
	@RunAsClient
	public void wrongCredentialsFormat(@ArquillianResteasyResource("authentication") final WebTarget authenticationEndpoint) {
		Response response = authenticationEndpoint.request().post(Entity.json(new Credentials("user", null)));
		assertTrue(response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE));
		assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	}
}

@ApplicationScoped
class TestDauphineCas implements DauphineCas {
	
	@Override
	public String authenticate(Credentials credentials) throws Exception {
		if (credentials.getUsername().equals("user") && credentials.getPassword().equals("password")) {
			return "test-token";
		}
		throw new Exception();
	}
	
	@Override
	public String validateToken(String token) throws Exception {
		if (token.equals("test-token")) {
			return "user";
		}
		throw new Exception();
	}
}