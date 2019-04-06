package io.github.oliviercailloux.y2018.opendata.cas;

import com.google.common.collect.ImmutableList;

/**
 * A proxy to the Dauphine CAS
 */
public interface DauphineCas {
    
    /**
     * Authenticate with the central dauphine CAS and issue a bearer token
     * @param credentials the dauphine credentials
     * @return the beared token
     * @throws DauphineCasException if the credentials are invalid
     */
    String authenticate(Credentials credentials) throws DauphineCasException;
    
    /**
     * Validate the token and return the username
     * @param token the bearer token
     * @return the username
     * @throws DauphineCasException if the token in invalid
     */
    String validateToken(String token) throws DauphineCasException;
    
    /**
     * Get the list of roles associated with a user
     * @param username a dauphine login
     * @return the list of roles
     * @throws DauphineCasException if the list of roles can't be retrieved
     */
    ImmutableList<String> getRoles(String username) throws DauphineCasException;
}
