package io.github.oliviercailloux.y2018.opendata.cas;

/**
 * This is the base exception for every errors related to the CAS.
 */
public class DauphineCasException extends Exception {
    public DauphineCasException(String s) {
        super(s);
    }
    
    public DauphineCasException() {
        super();
    }
}
