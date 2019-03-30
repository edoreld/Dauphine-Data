package io.github.oliviercailloux.y2018.opendata.cas;

/**
 * A proxy to the Dauphine CAS
 */
public interface DauphineCas {
    
    /**
     * Authenticate with the central dauphine CAS and issue a bearer token
     * @param credentials the dauphine credentials
     * @return the beared token
     * @throws Exception if the credentials are invalid
     */
    String authenticate(Credentials credentials) throws Exception;
    
    /**
     * Validate the token and return the username
     * @param token the bearer token
     * @return the username
     * @throws Exception if the token in invalid
     */
    String validateToken(String token) throws Exception;
}
