package io.github.oliviercailloux.y2018.opendata.provider;

import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import io.github.oliviercailloux.y2018.opendata.dao.EntityAlreadyExistsDaoException;
import io.github.oliviercailloux.y2018.opendata.dao.HttpAuditDao;
import io.github.oliviercailloux.y2018.opendata.entity.HttpAudit;
import io.github.oliviercailloux.y2018.opendata.service.DateService;
import io.swagger.v3.oas.models.PathItem.HttpMethod;

@Provider
public class TraceFilterProvider implements ContainerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(TraceFilterProvider.class);
	
	@Inject
	private DateService dateService;
	
	@Inject
	private HttpAuditDao httpAuditDao;

	@PostConstruct
	public void postConstruct() {
		Preconditions.checkNotNull(dateService, "dateService");
		Preconditions.checkNotNull(httpAuditDao, "httpAuditDao");
	}
	
	private void setUserIfAuthenticated(HttpAudit httpAudit, ContainerRequestContext requestContext) {
		ProviderCompanion.getUserFromRequest(requestContext).ifPresent(httpAudit::setUser);
	}
	
	private Optional<HttpAudit> makeHttpAudit(ContainerRequestContext requestContext, DateService dateService) {
		final Optional<HttpMethod> httpMethodOpt = ProviderCompanion.getHttpMethodFromRequest(requestContext);
		if(!httpMethodOpt.isPresent()) {
			return Optional.empty();
		}
		
		final HttpMethod httpMethod = httpMethodOpt.get();
		final Date date = dateService.getCurrentDate();
		final String path = ProviderCompanion.getPathFromRequest(requestContext);
		final HttpAudit httpAudit = new HttpAudit(date, path, httpMethod);
		setUserIfAuthenticated(httpAudit, requestContext);
		return Optional.of(httpAudit);
	}

	private Optional<HttpAudit> makeHttpAudit(ContainerRequestContext requestContext) {
		return makeHttpAudit(requestContext, dateService);
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) {		
		try {
			final Optional<HttpAudit> httpAuditOpt = makeHttpAudit(requestContext);
			httpAuditOpt.ifPresent(httpAuditDao::persist);
		} catch (EntityAlreadyExistsDaoException e) {
			LOGGER.error("failed to insert HttpAudit", e);
		}
	}

}
