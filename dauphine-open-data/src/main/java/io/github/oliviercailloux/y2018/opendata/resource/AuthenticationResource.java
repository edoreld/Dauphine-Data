package io.github.oliviercailloux.y2018.opendata.resource;

import io.github.oliviercailloux.y2018.opendata.annotation.Secured;
import io.github.oliviercailloux.y2018.opendata.cas.Credentials;
import io.github.oliviercailloux.y2018.opendata.cas.DauphineCas;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * This route allows the user to authenticate through the dauphine cas, generating a token for later access.
 */
@Path("/authentication")
public class AuthenticationResource {

    @Inject
    private DauphineCas dauphineCas;
    
    @Context
    private SecurityContext securityContext;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response authenticate(@Valid Credentials credentials) {
        try {
            String token = dauphineCas.authenticate(credentials);
            return Response.ok(token).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Secured
    @Path("whoami")
    public Response whoAmI() {
        String username = securityContext.getUserPrincipal().getName();
        return Response.ok(username).build();
    }
}
