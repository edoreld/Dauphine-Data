package io.github.oliviercailloux.y2018.opendata.resource;

import io.github.oliviercailloux.y2018.opendata.cas.Credentials;
import io.github.oliviercailloux.y2018.opendata.cas.DauphineCas;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This route allows the user to authenticate through the dauphine cas, generating a token for later access.
 */
@Path("/authentication")
public class AuthenticationResource {

    @Inject
    private DauphineCas dauphineCas;
    
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
}
