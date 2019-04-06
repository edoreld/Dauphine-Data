package io.github.oliviercailloux.y2018.opendata.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("healthcheck")
public class HealthCheck {

	@Context
	private Application application;
	
	@GET
	public Response healthCheck() {
		if(application == null) {
			return Response.serverError().build();
		}
		return Response.noContent().build();
	}
	
}
