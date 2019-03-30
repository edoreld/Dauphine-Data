package io.github.oliviercailloux.y2018.opendata.cas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 * This DauphineCas implementation is used during integration tests
 */
@ApplicationScoped
@Default
class TestDauphineCas implements DauphineCas {
    
    @Override
    public String authenticate(Credentials credentials) throws Exception {
        if (credentials.getUsername().equals("user") && credentials.getPassword().equals("password")) {
            return "test-token";
        }
        throw new Exception();
    }
    
    @Override
    public String validateToken(String token) throws Exception {
        if (token.equals("test-token")) {
            return "user";
        }
        throw new Exception();
    }
}