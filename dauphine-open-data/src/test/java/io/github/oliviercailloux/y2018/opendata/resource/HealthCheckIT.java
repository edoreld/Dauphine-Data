package io.github.oliviercailloux.y2018.opendata.resource;

import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.ArquillianUtils;

@RunWith(Arquillian.class)
public class HealthCheckIT {
	
	private Client client = ClientBuilder.newClient();;
	
	@ArquillianResource
	private URL url;
	
	@Deployment
	public static WebArchive makeWar() {
		return ArquillianUtils.makeWar("healthcheck");
	}
	
	@Before
	public void before() {
		Preconditions.checkNotNull(url, "url");
	}
	
	@Test
	public void testHealthcheck() throws URISyntaxException {
		Utils.assertStatusIsNoContent(client.target(url.toURI().toString()).path("/healthcheck").request().get());
	}
	
}
