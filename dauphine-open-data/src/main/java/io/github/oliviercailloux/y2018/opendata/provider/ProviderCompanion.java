package io.github.oliviercailloux.y2018.opendata.provider;

import java.security.Principal;
import java.util.Optional;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.models.PathItem.HttpMethod;
import lombok.experimental.UtilityClass;

@UtilityClass
class ProviderCompanion {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderCompanion.class);
	
	public static Optional<String> getUserFromRequest(ContainerRequestContext requestContext) {
		final SecurityContext sc = requestContext.getSecurityContext();
		if(sc != null) {
			final Principal p = requestContext.getSecurityContext().getUserPrincipal();
			if(p != null) {
				return Optional.of(p.getName());
			}
		}
		return Optional.empty();
	}
	
	public static Optional<HttpMethod> getHttpMethodFromRequest(ContainerRequestContext requestContext) {
		try {
			return Optional.of(HttpMethod.valueOf(requestContext.getMethod()));
		} catch (IllegalArgumentException e) {
			LOGGER.debug("fail to retrieve http method from request", e);
			return Optional.empty();
		}
	}
	
	public static String getPathFromRequest(ContainerRequestContext requestContext) {
		return requestContext.getUriInfo().getPath();
	}
	
}
