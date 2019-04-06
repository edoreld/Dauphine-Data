package io.github.oliviercailloux.y2018.opendata.cas;

import io.github.oliviercailloux.y2018.opendata.cas.FakeUserTable.FakeUserRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.*;

/**
 * This class is a fake proxy to the Dauphine CAS.
 */
@Default
@ApplicationScoped
public class FakeDauphineCas implements DauphineCas {
    
    private FakeTokenIssuer tokenIssuer = new FakeTokenIssuer();
    private FakeUserTable userTable = new FakeUserTable();
    
    @Override
    public String authenticate(Credentials credentials) throws DauphineCasException {
        FakeUserRecord user = userTable.getUser(credentials.getUsername())
                .orElseThrow(() -> new DauphineCasException("Unknown user " + credentials.getUsername()));

        if (!user.getPassword().equals(credentials.getPassword())) {
            throw new DauphineCasException("Invalid credentials");
        }

        return tokenIssuer.issueToken(credentials.getUsername());
    }
    
    @Override
    public String validateToken(String token) throws DauphineCasException {
        return tokenIssuer.validateToken(token).orElseThrow(() -> new DauphineCasException("Invalid token " + token));
    }
    
    @Override
    public String[] getRoles(String username) throws DauphineCasException {
        return userTable.getUser(username)
                .map(FakeUserRecord::getRoles)
                .orElseThrow(() -> new DauphineCasException("Unknown user " + username));
    }
}

/**
 * This is a fake user table containing (login, password, roles) tuples.
 */
class FakeUserTable {
    
    @AllArgsConstructor
    @Getter
    @Setter
    static class FakeUserRecord {
        private String username;
        private String password;
        private String[] roles;
    }
    
    private Map<String, FakeUserRecord> table;
    {
        table = new HashMap<>();
        addUser("loic", "123", new String[]{Roles.STUDENT});
        addUser("marcel", "456", new String[]{Roles.TEACHER});
        addUser("sylvie", "789", new String[]{Roles.ADMIN, Roles.TEACHER});
    }
    
    Optional<FakeUserRecord> getUser(String username) {
        return Optional.ofNullable(table.get(username));
    }
    
    private void addUser(String username, String password, String[] roles) {
        table.put(username, new FakeUserRecord(username, password, roles));
    }
}

/**
 * This is a Fake Service that issue tokens for the FakeDauphineCas proxy.
 */
class FakeTokenIssuer {
    
    private Map<String, String> tokenCache = new HashMap<>();
    
    private String generateRandomToken() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * Generate a token (infinite validity) for a given user
     * @param username a dauphine login
     * @return the issued token
     */
    String issueToken(String username) {
        final String token = generateRandomToken();
        tokenCache.put(token, username);
        return token;
    }
    
    /**
     * Validate a token
     * @param token the token
     * @return the username or nothing if the token is invalid
     */
    Optional<String> validateToken(String token) {
        return Optional.ofNullable(tokenCache.get(token));
    }
}