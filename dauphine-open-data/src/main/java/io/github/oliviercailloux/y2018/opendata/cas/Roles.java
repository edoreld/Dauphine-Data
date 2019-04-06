package io.github.oliviercailloux.y2018.opendata.cas;

/**
 * This class contains static constants for known Dauphine CAS roles.
 *
 * Roles could be modeled as an Enum type, but it would not fit with their dynamic nature, so we rather use Strings
 * and define some constants for known roles.
 */
public class Roles {
    public static String ADMIN = "admin";
    public static String TEACHER = "teacher";
    public static String STUDENT = "student";
}