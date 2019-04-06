package io.github.oliviercailloux.y2018.opendata.resource;

import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusIsNoContent;
import static io.github.oliviercailloux.y2018.opendata.resource.Utils.assertStatusIsServerError;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class HealthCheckTest {

	private HealthCheck healthcheck = new HealthCheck();
	
	@Test
	public void testContextLoaded() {
		ReflectionTestUtils.setField(healthcheck, "application", new Application());
		final Response response = healthcheck.healthCheck();
		assertStatusIsNoContent(response);
	}
	
	@Test
	public void testContextNotLoaded() {
		ReflectionTestUtils.setField(healthcheck, "application", null);
		final Response response = healthcheck.healthCheck();
		assertStatusIsServerError(response);
	}
	
}
