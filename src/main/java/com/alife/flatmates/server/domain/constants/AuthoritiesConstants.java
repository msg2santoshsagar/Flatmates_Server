package com.alife.flatmates.server.domain.constants;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";
    
    public static final String GROUP_ADMIN = "ROLE_GROUP_ADMIN";
    
    public static final String GROUP_USER  = "ROLE_GROUP_USER";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}
