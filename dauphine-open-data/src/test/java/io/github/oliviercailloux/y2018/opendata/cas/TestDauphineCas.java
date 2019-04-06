package io.github.oliviercailloux.y2018.opendata.cas;

import com.google.common.collect.ImmutableList;

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
    
    public final static String TEACHER_USERNAME = "teacher";
    public final static String TEACHER_PASSWORD = "teacher-password";
    public final static String TEACHER_TOKEN = "teacher-token";
    
    
    @Override
    public String authenticate(Credentials credentials) throws DauphineCasException {
        if (credentials.getUsername().equals(ADMIN_USERNAME) && credentials.getPassword().equals(ADMIN_PASSWORD)) {
            return ADMIN_TOKEN;
        }
        if (credentials.getUsername().equals(STUDENT_USERNAME) && credentials.getPassword().equals(STUDENT_PASSWORD)) {
            return STUDENT_TOKEN;
        }
        if (credentials.getUsername().equals(TEACHER_USERNAME) && credentials.getPassword().equals(TEACHER_PASSWORD)) {
            return TEACHER_TOKEN;
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
        if (token.equals(TEACHER_TOKEN)) {
            return TEACHER_USERNAME;
        }
        throw new DauphineCasException();
    }
    
    @Override
    public ImmutableList<String> getRoles(String username) throws DauphineCasException {
        if (username.equals(ADMIN_USERNAME)) {
            return ImmutableList.of(Roles.ADMIN);
        }
        if (username.equals(STUDENT_USERNAME)) {
            return ImmutableList.of(Roles.STUDENT);
        }
        if (username.equals(TEACHER_USERNAME)) {
            return ImmutableList.of(Roles.TEACHER);
        }
        throw new DauphineCasException();
    }
}