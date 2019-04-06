package io.github.oliviercailloux.y2018.opendata.provider;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

/**
 * This filter perform authorization using standard java annotations @DenyAll, @PermitAll and @RolesAllowed.
 * Theses annotation can either stand on resource classes or methods.
 * There is some precedences rules implemented in the logic of the filter method, read the comments for more understanding.
 *
 * The annotation @PermitAll is the default.
 * You can mix authorization and @Secured (for authentication)
 * The annotation @RolesAllowed should always be set with @Secured, otherwise it rejects all requests.
 *
 * the Priority annotation below is required for this filter to be ran after the AuthenticationFilter
 */
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {
    
    @Context
    private ResourceInfo resourceInfo;
    
    @Override
    public void filter(ContainerRequestContext requestContext) {
        
        Method method = resourceInfo.getResourceMethod();
        
        // @DenyAll on the method takes precedence over @RolesAllowed and @PermitAll
        if (method.isAnnotationPresent(DenyAll.class)) {
            refuseRequest(requestContext);
            return ;
        }
        
        // @RolesAllowed on the method takes precedence over @PermitAll
        RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
        if (rolesAllowed != null) {
            performAuthorization(rolesAllowed.value(), requestContext);
            return;
        }
        
        // @PermitAll on the method takes precedence over @RolesAllowed on the class
        if (method.isAnnotationPresent(PermitAll.class)) {
            // Do nothing
            return;
        }
        
        // @DenyAll can't be attached to classes
        
        // @RolesAllowed on the class takes precedence over @PermitAll on the class
        rolesAllowed =
                resourceInfo.getResourceClass().getAnnotation(RolesAllowed.class);
        if (rolesAllowed != null) {
            performAuthorization(rolesAllowed.value(), requestContext);
        }
        
        // @PermitAll on the class
        if (resourceInfo.getResourceClass().isAnnotationPresent(PermitAll.class)) {
            // Do nothing
            return;
        }
    }
    
    /**
     * Perform authorization based on roles.
     *
     * @param rolesAllowed
     * @param requestContext
     */
    private void performAuthorization(String[] rolesAllowed,
                                      ContainerRequestContext requestContext) {
        
        if (rolesAllowed.length > 0 && !isAuthenticated(requestContext)) {
            refuseRequest(requestContext);
        }
        
        for (final String role : rolesAllowed) {
            if (requestContext.getSecurityContext().isUserInRole(role)) {
                return;
            }
        }
        
        refuseRequest(requestContext);
    }
    
    /**
     * Check if the user is authenticated.
     *
     * @param requestContext
     * @return
     */
    private boolean isAuthenticated(final ContainerRequestContext requestContext) {
        return requestContext.getSecurityContext().getUserPrincipal() != null;
    }
    
    /**
     * Refuse the request.
     */
    private void refuseRequest(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response.status(Response.Status.FORBIDDEN).build());
    }
}