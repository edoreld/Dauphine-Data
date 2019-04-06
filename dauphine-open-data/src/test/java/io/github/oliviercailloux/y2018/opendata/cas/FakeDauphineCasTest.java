package io.github.oliviercailloux.y2018.opendata.cas;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.management.relation.Role;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.then;

/**
 * This unit test class ensure the FakeDauphineCas is working as expected.
 * <p>
 * FakeDauphineCas is populated with a fake user list. We expect the user "loic" exists and has password "123" and role
 * "student"
 */
public class FakeDauphineCasTest {
    
    private FakeDauphineCas cas;
    
    @Before
    public void setup() {
        cas = new FakeDauphineCas();
    }
    
    @Test
    public void testSequence() throws DauphineCasException {
        String token = cas.authenticate(new Credentials("loic", "123"));
        assertEquals("loic", cas.validateToken(token));
        // should not throw any exception
    }
    
    @Test(expected = DauphineCasException.class)
    public void testWrongCredentials() throws DauphineCasException {
        cas.authenticate(new Credentials("loic", "aaaaaaa"));
    }
    
    @Test(expected = DauphineCasException.class)
    public void testWrongToken() throws DauphineCasException {
        cas.validateToken("bbbbbb");
    }
    
    @Test
    public void testRoles() throws DauphineCasException {
        assertArrayEquals(new String[]{Roles.STUDENT}, cas.getRoles("loic"));
    }
    
    @Test(expected = DauphineCasException.class)
    public void testRolesWrongUser() throws DauphineCasException {
        cas.getRoles("bababa");
    }
}
