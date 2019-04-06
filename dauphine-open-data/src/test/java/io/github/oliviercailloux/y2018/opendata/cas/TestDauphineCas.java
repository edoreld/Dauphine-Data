package io.github.oliviercailloux.y2018.opendata.cas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 * This DauphineCas implementation is used during integration tests
 */
@ApplicationScoped
@Default
public class TestDauphineCas implements DauphineCas {
    
    public final static String TEST_USERNAME = "user";
    public final static String TEST_PASSWORD = "password";
    public final static String TEST_TOKEN = "test-token";
    
    @Override
    public String authenticate(Credentials credentials) throws Exception {
        if (credentials.getUsername().equals(TEST_USERNAME) && credentials.getPassword().equals(TEST_PASSWORD)) {
            return TEST_TOKEN;
        }
        throw new Exception();
    }
    
    @Override
    public String validateToken(String token) throws Exception {
        if (token.equals(TEST_TOKEN)) {
            return TEST_USERNAME;
        }
        throw new Exception();
    }
}