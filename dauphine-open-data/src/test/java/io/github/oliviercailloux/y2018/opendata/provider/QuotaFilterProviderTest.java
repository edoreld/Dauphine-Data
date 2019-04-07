package io.github.oliviercailloux.y2018.opendata.provider;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.security.Principal;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuotaFilterProviderTest {

	private static final String USER_1 = "aclaudel";  
	private static final String PATH_1 = "/test";
	
	@Mock
	private ContainerRequestContext requestContext;
	
	@Mock
	private SecurityContext securityContext;
	
	@Mock
	private Principal principal;
	
	@Mock
	private UriInfo uriInfo;
	
	private RequestContextUtils requestContextUtils;
	
	private QuotaFilterProvider quotaFilterProvider = new QuotaFilterProvider();
	
	@Before
	public void before() {
		requestContextUtils = new RequestContextUtils(requestContext, securityContext, principal, uriInfo);
	}
	
	@Test
	public void testNotAuthenticated() {
		requestContextUtils.setUpNotAuthenticatedSecurityContext1();
		quotaFilterProvider.filter(requestContext);
		then(requestContext).should(never()).abortWith(any(Response.class));
	}
	
	@Test
	public void testAuthenticatedQuotaOk() {
		requestContextUtils.setUpNominalRequest("GET", PATH_1);
		requestContextUtils.setUpNominalSecurityContext(USER_1);
		quotaFilterProvider.filter(requestContext);
		then(requestContext).should(never()).abortWith(any(Response.class));
	}
	
	@Test
	public void testAuthenticatedQuotaKO() {
		requestContextUtils.setUpNominalRequest("GET", PATH_1);
		requestContextUtils.setUpNominalSecurityContext(USER_1);
		for(int i = 0; i < 11; i++)
			quotaFilterProvider.filter(requestContext);
		then(requestContext).should(times(1)).abortWith(any(Response.class));
	}
	
}
