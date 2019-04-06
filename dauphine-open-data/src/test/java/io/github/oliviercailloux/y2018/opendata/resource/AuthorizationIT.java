package io.github.oliviercailloux.y2018.opendata.resource;

import io.github.oliviercailloux.y2018.opendata.ArquillianUtils;
import io.github.oliviercailloux.y2018.opendata.cas.TestDauphineCas;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AuthorizationIT {

	@Deployment
	public static WebArchive makeWar() {
        return ArquillianUtils.makeWar("resource-it-war");
	}
	
    @Test
	@RunAsClient
	public void permitAll(@ArquillianResteasyResource("test/authorization/permitAll") final WebTarget endpoint) {
		Response response = endpoint.request().get();
		assertEquals(200, response.getStatus());
	}
    
    @Test
    @RunAsClient
    public void permitAllSecured(@ArquillianResteasyResource("test/authorization/permitAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(200, response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void permitAllSecuredFailure(@ArquillianResteasyResource("test/authorization/permitAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void denyAll(@ArquillianResteasyResource("test/authorization/denyAll") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void denyAllSecured(@ArquillianResteasyResource("test/authorization/denyAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void denyAllSecuredFailure(@ArquillianResteasyResource("test/authorization/denyAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
    
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminMissingSecured(@ArquillianResteasyResource("test/authorization/rolesAllowedAdmin") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminMissingSecuredWithToken(@ArquillianResteasyResource("test/authorization/rolesAllowedAdmin") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminSecured(@ArquillianResteasyResource("test/authorization/rolesAllowedAdminSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminSecuredNoToken(@ArquillianResteasyResource("test/authorization/rolesAllowedAdminSecured") final WebTarget endpoint) {
        Response response = endpoint.request().get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminSecuredWrongToken(@ArquillianResteasyResource("test/authorization/rolesAllowedAdminSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN + "qsdqs").get();
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminSecuredNotAllowed(@ArquillianResteasyResource("test/authorization/rolesAllowedAdminSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.STUDENT_TOKEN).get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void rolesAllowedAdminAndStudentSecured(@ArquillianResteasyResource("test/authorization/rolesAllowedAdminAndStudentSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.STUDENT_TOKEN).get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Response response2 = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.OK.getStatusCode(), response2.getStatus());
    }
    
    @Test
    @RunAsClient
    public void denyAllOverRoleAllowedAdminSecured(@ArquillianResteasyResource("test/authorization/denyAllOverRoleAllowedAdminSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void roleAllowedAdminOverPermitAllSecured(@ArquillianResteasyResource("test/authorization/roleAllowedAdminOverPermitAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.ADMIN_TOKEN).get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    
    @Test
    @RunAsClient
    public void roleAllowedAdminOverPermitAllSecuredFailure(@ArquillianResteasyResource("test/authorization/roleAllowedAdminOverPermitAllSecured") final WebTarget endpoint) {
        Response response = endpoint.request().header("authorization", "Bearer " + TestDauphineCas.STUDENT_TOKEN).get();
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus());
    }
    
}