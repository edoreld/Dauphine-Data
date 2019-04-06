package io.github.oliviercailloux.y2018.opendata.cas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 * This DauphineCas implementation is used during integration tests
 */
@ApplicationScoped
@Default
public class TestDauphineCas implements DauphineCas {
    
    public final static String ADMIN_USERNAME = "admin";
    public final static String ADMIN_PASSWORD = "admin-password";
    public final static String ADMIN_TOKEN = "admin-token";
    
    public final static String STUDENT_USERNAME = "user";
    public final static String STUDENT_PASSWORD = "user-password";
    public final static String STUDENT_TOKEN = "user-token";
    
    
    @Override
    public String authenticate(Credentials credentials) throws DauphineCasException {
        if (credentials.getUsername().equals(ADMIN_USERNAME) && credentials.getPassword().equals(ADMIN_PASSWORD)) {
            return ADMIN_TOKEN;
        }
        if (credentials.getUsername().equals(STUDENT_USERNAME) && credentials.getPassword().equals(STUDENT_PASSWORD)) {
            return STUDENT_TOKEN;
        }
        throw new DauphineCasException();
    }
    
    @Override
    public String validateToken(String token) throws DauphineCasException {
        if (token.equals(ADMIN_TOKEN)) {
            return ADMIN_USERNAME;
        }
        if (token.equals(STUDENT_TOKEN)) {
            return STUDENT_USERNAME;
        }
        throw new DauphineCasException();
    }
    
    @Override
    public String[] getRoles(String username) throws DauphineCasException {
        if (username.equals(ADMIN_USERNAME)) {
            return new String[] {Roles.ADMIN};
        }
        if (username.equals(STUDENT_USERNAME)) {
            return new String[] {Roles.STUDENT};
        }
        throw new DauphineCasException();
    }
}