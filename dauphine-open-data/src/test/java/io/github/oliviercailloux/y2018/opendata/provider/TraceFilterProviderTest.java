package io.github.oliviercailloux.y2018.opendata.provider;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;

import java.security.Principal;
import java.util.Date;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.HttpAuditDao;
import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit;
import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit.HttpMethod;
import io.github.oliviercailloux.y2018.opendata.service.DateService;

@RunWith(MockitoJUnitRunner.class)
public class TraceFilterProviderTest {

	@Mock
	private DateService dateService;
	
	@Mock
	private HttpAuditDao httpAuditDao;
	
	@InjectMocks
	private TraceFilterProvider traceFilterProvider;
	
	@Mock
	private ContainerRequestContext requestContext;
	
	@Mock
	private SecurityContext securityContext;
	
	@Mock
	private Principal principal;
	
	@Mock
	private UriInfo uriInfo;
	
	private void setUpNominalRequest(final String method, final String path, final Date date) {
		given(requestContext.getMethod()).willReturn(method);
		given(requestContext.getUriInfo()).willReturn(uriInfo);
		given(uriInfo.getPath()).willReturn(path);
		given(dateService.getCurrentDate()).willReturn(date);
	}
	
	private void setUpNominalSecurityContext(final String user) {
		given(requestContext.getSecurityContext()).willReturn(securityContext);
		given(principal.getName()).willReturn(user);
		given(securityContext.getUserPrincipal()).willReturn(principal);
	}
	
	private void setUpNotAuthenticatedSecurityContext1() {
		given(requestContext.getSecurityContext()).willReturn(null);
	}
	
	private void setUpNotAuthenticatedSecurityContext2() {
		given(requestContext.getSecurityContext()).willReturn(securityContext);
		given(securityContext.getUserPrincipal()).willReturn(null);
	}
	
	private void assertPersisted(final HttpAudit httpAudit) throws EntityAlreadyExistsDaoException {
		then(httpAuditDao).should(atLeastOnce()).persist(httpAudit);
	}	
	
	private void startAndAssertPersisted(HttpAudit httpAudit) throws EntityAlreadyExistsDaoException {
		traceFilterProvider.filter(requestContext);
		assertPersisted(httpAudit);
	}
	
	private void startAndAssertNoPersist() throws EntityAlreadyExistsDaoException {
		traceFilterProvider.filter(requestContext);
		then(httpAuditDao).should(Mockito.never()).persist(Mockito.any());
	}
	
	@Test
	public void testNominal() throws EntityAlreadyExistsDaoException {
		final String method = "GET";
		final String path = "/home";
		final String user = "aclaudel";
		final Date date = new Date(1L);
		
		setUpNominalRequest(method, path, date);
		setUpNominalSecurityContext(user);
		final HttpAudit httpAudit = new HttpAudit(date, path, HttpMethod.from(method));
		httpAudit.setUser(user);
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testNotAuthenticated1() throws EntityAlreadyExistsDaoException {
		final String method = "GET";
		final String path = "/home";
		final Date date = new Date(1L);
		
		setUpNominalRequest(method, path, date);
		setUpNotAuthenticatedSecurityContext1();
		final HttpAudit httpAudit = new HttpAudit(new Date(1L), path, HttpMethod.from(method));
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testNotAuthenticated2() throws EntityAlreadyExistsDaoException {
		final String method = "GET";
		final String path = "/home";
		final Date date = new Date(1L);
		
		setUpNominalRequest(method, path, date);
		setUpNotAuthenticatedSecurityContext2();
		final HttpAudit httpAudit = new HttpAudit(new Date(1L), path, HttpMethod.from(method));
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testUnsupportedHttpMethod() throws EntityAlreadyExistsDaoException {
		final String method = "UNSUPPORTED";
		final String path = "/home";
		final String user = "arnaud";
		final Date date = new Date(1L);
		setUpNominalRequest(method, path, date);
		setUpNominalSecurityContext(user);
		startAndAssertNoPersist();
	}
	
}
