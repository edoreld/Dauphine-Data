package io.github.oliviercailloux.y2018.opendata.cas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 * This class is a fake proxy to the Dauphine CAS.
 */
@Default
@ApplicationScoped
public class FakeDauphineCas implements DauphineCas {
    
    @Override
    public String authenticate(Credentials credentials) throws Exception {
        return "fake-token";
    }
    
    @Override
    public String validateToken(String token) throws Exception {
        return "toto";
    }
}
