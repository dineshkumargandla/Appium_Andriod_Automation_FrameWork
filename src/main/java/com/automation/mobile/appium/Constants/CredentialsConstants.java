package com.automation.mobile.appium.Constants;

public class CredentialsConstants {

    public static String VALID_USERNAME = "standard_user";

    public static String VALID_PASSWORD = "secret_sauce";

    public static String IN_VALID_USERNAME = "INVALID_USER";

    public static String IN_VALID_PASSWORD = "INVALID_PASSWORD";

    public static String LOCKED_OUT_USER = "locked_out_user";

    public static String PROBLEM_USER = "problem_user";

    public static String PERFORMANCE_GLITCH_USER = "performance_glitch_user";

    public static String getValidUsername() {
        return VALID_USERNAME;
    }

    public static void setValidUsername(String validUsername) {
        VALID_USERNAME = validUsername;
    }

    public static String getValidPassword() {
        return VALID_PASSWORD;
    }

    public static void setValidPassword(String validPassword) {
        VALID_PASSWORD = validPassword;
    }

    public static String getInValidUsername() {
        return IN_VALID_USERNAME;
    }

    public static void setInValidUsername(String inValidUsername) {
        IN_VALID_USERNAME = inValidUsername;
    }

    public static String getInValidPassword() {
        return IN_VALID_PASSWORD;
    }

    public static void setInValidPassword(String inValidPassword) {
        IN_VALID_PASSWORD = inValidPassword;
    }

    public static String getLockedOutUser() {
        return LOCKED_OUT_USER;
    }

    public static void setLockedOutUser(String lockedOutUser) {
        LOCKED_OUT_USER = lockedOutUser;
    }

    public static String getProblemUser() {
        return PROBLEM_USER;
    }

    public static void setProblemUser(String problemUser) {
        PROBLEM_USER = problemUser;
    }

    public static String getPerformanceGlitchUser() {
        return PERFORMANCE_GLITCH_USER;
    }

    public static void setPerformanceGlitchUser(String performanceGlitchUser) {
        PERFORMANCE_GLITCH_USER = performanceGlitchUser;
    }
}
