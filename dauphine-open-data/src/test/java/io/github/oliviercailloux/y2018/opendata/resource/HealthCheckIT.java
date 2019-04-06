package io.github.oliviercailloux.y2018.opendata.resource;

import java.net.URISyntaxException;

import org.junit.Test;

import io.github.oliviercailloux.y2018.opendata.AbstractArquillianIT;

public class HealthCheckIT extends AbstractArquillianIT {
	
	@Test
	public void testHealthcheck() throws URISyntaxException {
		Utils.assertStatusIsNoContent(Utils.getRequest(client, url, "healthcheck").get());
	}

	
	
}
