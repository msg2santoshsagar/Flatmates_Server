package com.alife.flatmates.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alife.flatmates.server.security.SecurityUtils;

@RestController
@RequestMapping(value="/")
public class AuthenticationController {

	@GetMapping(value="/auth")
	public String geLoggedInUserDetail(){
		return SecurityUtils.getCurrentUserLogin();
	}
	
	
}
