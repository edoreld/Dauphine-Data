package io.github.oliviercailloux.y2018.opendata.cas;

import io.github.oliviercailloux.y2018.opendata.annotation.Secured;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * This is a JAX-RS resource for testing different combination of authentication and authorization annotations
 */
@Path("/test/authorization")
public class AuthorizationResource {
    
    @GET
    @Path("permitAll")
    @PermitAll
    public Response permitAll() {
        return Response.ok().build();
    }
    
    @GET
    @Path("permitAllSecured")
    @PermitAll
    @Secured
    public Response permitAllSecured() {
        return Response.ok().build();
    }
    
    @GET
    @Path("denyAll")
    @DenyAll
    public Response denyAll() {
        return Response.ok().build();
    }
    
    @GET
    @Path("denyAllSecured")
    @DenyAll
    @Secured
    public Response denyAllSecured() {
        return Response.ok().build();
    }
    
    @GET
    @Path("rolesAllowedAdmin")
    @RolesAllowed({Roles.ADMIN})
    public Response rolesAllowedAdmin(){
        return Response.ok().build();
    }
    
    @GET
    @Path("rolesAllowedAdminSecured")
    @Secured
    @RolesAllowed({Roles.ADMIN})
    public Response rolesAllowedAdminSecured(){
        return Response.ok().build();
    }
    
    @GET
    @Path("rolesAllowedAdminAndStudentSecured")
    @Secured
    @RolesAllowed({Roles.ADMIN, Roles.STUDENT})
    public Response rolesAllowedAdminAndStudentSecured(){
        return Response.ok().build();
    }
    
    @GET
    @Path("denyAllOverRoleAllowedAdminSecured")
    @Secured
    @DenyAll
    @RolesAllowed({Roles.ADMIN})
    public Response denyAllOverRoleAllowedAdminSecured(){
        return Response.ok().build();
    }
    
    @GET
    @Path("roleAllowedAdminOverPermitAllSecured")
    @Secured
    @PermitAll
    @RolesAllowed({Roles.ADMIN})
    public Response roleAllowedAdminOverPermitAllSecured(){
        return Response.ok().build();
    }
}
