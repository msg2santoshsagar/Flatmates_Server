package com.alife.flatmates.server.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alife.flatmates.server.domain.FCM;
import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.service.FCMService;
import com.alife.flatmates.server.service.UserService;

@RestController
@RequestMapping("/api/fcm")
public class FcmController {

	private final UserService  userService;
	
	private final FCMService fcmService;

	public FcmController(UserService userService, FCMService fcmService) {
		this.userService     = userService;
		this.fcmService      = fcmService;
	}



	@PostMapping(value="/saveToken",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public FCM saveToken(@RequestBody FCM fcmParam){
		
		System.out.println("Request to save fcm token : "+fcmParam);
		
		User user 	  = userService.findUserObjectWithId(fcmParam.getUserName());
		
		fcmParam.setUser(user);
		fcmParam = fcmService.save(fcmParam);
		return fcmParam;
	}
	
}