package io.github.oliviercailloux.y2018.opendata.provider;

import static com.google.common.base.Predicates.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.Test;

import io.github.oliviercailloux.y2018.opendata.AbstractArquillianIT;
import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.HttpAuditDao;
import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit;
import io.github.oliviercailloux.y2018.opendata.resource.Utils;

public class TraceFilterProviderIT extends AbstractArquillianIT {

	private static final String HEALTHCHECK_PATH = "/healthcheck";
	
	@Inject
	private HttpAuditDao httpAuditDao;
	
	private HttpAudit getLastInserted(List<HttpAudit> oldAudits, List<HttpAudit> newAudits) {
		System.err.println(oldAudits);
		System.err.println(newAudits);
		return newAudits.stream().filter(not(oldAudits::contains)).findAny().get();
	}
	
	@Test
	public void testHealthCheckMonitoring() throws EntityAlreadyExistsDaoException {
		final Date dateBeforeCall = new Date();
		final List<HttpAudit> oldAudits = httpAuditDao.findAll();
		final Response response = Utils.getRequest(client, url, HEALTHCHECK_PATH).get();
		Utils.assertStatusIsNoContent(response);
		final List<HttpAudit> newAudits = httpAuditDao.findAll();
		assertEquals("no new audit line", oldAudits.size() +1, newAudits.size());
		final HttpAudit lastInserted = getLastInserted(oldAudits, newAudits);
		assertFalse("the request has a user", lastInserted.getUser().isPresent());
		assertEquals("wrong path", HEALTHCHECK_PATH, lastInserted.getPath());
		assertEquals("wrong method", "GET", lastInserted.getHttpMethod().toString());
		assertTrue("date older than current date", lastInserted.getDate().getTime() < new Date().getTime());
		assertTrue("date older than webservice call date", dateBeforeCall.getTime() < lastInserted.getDate().getTime());	
	}
	
}
