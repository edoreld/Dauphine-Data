package io.github.oliviercailloux.y2018.opendata;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("home")
public class IbmCloudHello {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Site Dauphine Open Data en construction....";
	}
}
