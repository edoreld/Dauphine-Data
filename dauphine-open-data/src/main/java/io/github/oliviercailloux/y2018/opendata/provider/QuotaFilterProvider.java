package io.github.oliviercailloux.y2018.opendata.provider;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@ApplicationScoped
public class QuotaFilterProvider implements ContainerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuotaFilterProvider.class);
	
	private final ConcurrentHashMap<String, UserQuota> quotas = new ConcurrentHashMap<>();
	
	private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
	private UserQuota registerQuota(UserQuota userquota) { 
		executor.schedule(userquota::clearAll, userquota.getRate(), TimeUnit.SECONDS);
		return userquota;
	}
	
	private Function<String, UserQuota> makeDefaultQuota(String user) {
		return s -> registerQuota(UserQuota.make(user, 10, 10));
	}
	
	private UserQuota getUserQuota(String user) {
		return quotas.computeIfAbsent(user, makeDefaultQuota(user));
	}
	
	private Response makeQuotaExceededResponse(UserQuota quota) {
		return Response.status(429, "quota exceeded : " + quota.getLimit()).build();
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) {
		final Optional<String> userOpt = ProviderCompanion.getUserFromRequest(requestContext);
		
		if(!userOpt.isPresent()) {
			LOGGER.info("no authenticated user, quota cannot be applied");
			return;
		}
		
		final String user = userOpt.get();
		final String path = ProviderCompanion.getPathFromRequest(requestContext);
		UserQuota quota = getUserQuota(user);
		final boolean limitNotExceed = quota.visit(path);
		if(!limitNotExceed) {
			LOGGER.info("aborting request because of exceed quota");
			requestContext.abortWith(makeQuotaExceededResponse(quota));
		}
	}

}
