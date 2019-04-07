package io.github.oliviercailloux.y2018.opendata.provider;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;

import java.security.Principal;
import java.util.Date;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.HttpAuditDao;
import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit;
import io.github.oliviercailloux.y2018.opendata.service.DateService;
import io.swagger.v3.oas.models.PathItem.HttpMethod;

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
	
	private RequestContextUtils requestContextUtils;
	
	@Before
	public void before() {
		requestContextUtils = new RequestContextUtils(requestContext, securityContext, principal, uriInfo);
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
		
		requestContextUtils.setUpNominalRequest(method, path);
		given(dateService.getCurrentDate()).willReturn(date);
		requestContextUtils.setUpNominalSecurityContext(user);
		final HttpAudit httpAudit = new HttpAudit(date, path, HttpMethod.valueOf(method));
		httpAudit.setUser(user);
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testNotAuthenticated1() throws EntityAlreadyExistsDaoException {
		final String method = "GET";
		final String path = "/home";
		final Date date = new Date(1L);
		
		requestContextUtils.setUpNominalRequest(method, path);
		given(dateService.getCurrentDate()).willReturn(date);
		requestContextUtils.setUpNotAuthenticatedSecurityContext1();
		final HttpAudit httpAudit = new HttpAudit(new Date(1L), path, HttpMethod.valueOf(method));
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testNotAuthenticated2() throws EntityAlreadyExistsDaoException {
		final String method = "GET";
		final String path = "/home";
		final Date date = new Date(1L);
		
		requestContextUtils.setUpNominalRequest(method, path);
		given(dateService.getCurrentDate()).willReturn(date);
		requestContextUtils.setUpNotAuthenticatedSecurityContext2();
		final HttpAudit httpAudit = new HttpAudit(new Date(1L), path, HttpMethod.valueOf(method));
		startAndAssertPersisted(httpAudit);
	}
	
	@Test
	public void testUnsupportedHttpMethod() throws EntityAlreadyExistsDaoException {
		final String method = "UNSUPPORTED";
		final String path = "/home";
		final String user = "arnaud";
		final Date date = new Date(1L);
		requestContextUtils.setUpNominalRequest(method, path);
		given(dateService.getCurrentDate()).willReturn(date);
		requestContextUtils.setUpNominalSecurityContext(user);
		startAndAssertNoPersist();
	}
	
}
