package com.alife.flatmates.server.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.alife.flatmates.server.domain.constants.ApplicationConstants;
import com.alife.flatmates.server.security.SecurityUtils;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentUserLogin();
        return userName != null ? userName : ApplicationConstants.SYSTEM_ACCOUNT;
    }
}
