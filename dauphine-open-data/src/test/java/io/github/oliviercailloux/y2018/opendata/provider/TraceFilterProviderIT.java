package io.github.oliviercailloux.y2018.opendata.provider;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.oliviercailloux.y2018.opendata.ArquillianUtils;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.HttpAuditDao;
import io.github.oliviercailloux.y2018.opendata.resource.Utils;

@RunWith(Arquillian.class)
public class TraceFilterProviderIT {

	private Client client = ClientBuilder.newClient();
	
	@Inject
	private HttpAuditDao httpAuditDao;
	
	@ArquillianResource
	private URL url;
	
	@Deployment
	public static WebArchive makeWar() {
		return ArquillianUtils.makeWar("trace-filter");
	}
	
	@Test
	public void testHealthCheck() throws EntityAlreadyExistsDaoException {
		final int auditSizeBefore = httpAuditDao.findAll().size();
		final Response response = Utils.getRequest(client, url, "/healthcheck").get();
		Utils.assertStatusIsNoContent(response);
		final int auditSizeAfter = httpAuditDao.findAll().size();
		assertEquals("no new audit line", auditSizeBefore +1, auditSizeAfter);
	}
	
}
