package com.alife.flatmates.server.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AlwaysSendUnauthorized401AuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex)
			throws IOException, ServletException {
		System.out.println("Pre-authenticated entry point called, Rejecting access.");
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Pre-authenticated entry point called, Rejecting access.");
		
	}

}
