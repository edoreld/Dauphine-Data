package io.github.oliviercailloux.y2018.opendata.provider;

import static org.mockito.BDDMockito.given;

import java.security.Principal;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class RequestContextUtils {

	ContainerRequestContext requestContext;
	
	SecurityContext securityContext;
	
	Principal principal;
	
	UriInfo uriInfo;
	
	void setUpNominalRequest(final String method, final String path) {
		given(requestContext.getMethod()).willReturn(method);
		given(requestContext.getUriInfo()).willReturn(uriInfo);
		given(uriInfo.getPath()).willReturn(path);
	}
	
	void setUpNominalSecurityContext(final String user) {
		given(requestContext.getSecurityContext()).willReturn(securityContext);
		given(principal.getName()).willReturn(user);
		given(securityContext.getUserPrincipal()).willReturn(principal);
	}
	
	void setUpNotAuthenticatedSecurityContext1() {
		given(requestContext.getSecurityContext()).willReturn(null);
	}
	
	void setUpNotAuthenticatedSecurityContext2() {
		given(requestContext.getSecurityContext()).willReturn(securityContext);
		given(securityContext.getUserPrincipal()).willReturn(null);
	}
	
}
