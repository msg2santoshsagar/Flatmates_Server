package com.alife.flatmates.server.service;

import org.springframework.stereotype.Service;

import com.alife.flatmates.server.domain.FCM;
import com.alife.flatmates.server.domain.User;
import com.alife.flatmates.server.repository.FcmRepository;

@Service
public class FCMService {

	private final FcmRepository fcmRepository;
	
	public FCMService(FcmRepository fcmRepository) {
		this.fcmRepository = fcmRepository;
	}

	public FCM save(FCM fcmParam) {
		
		String deviceType = fcmParam.getDeviceType();
		User   user 	  = fcmParam.getUser();
		
		Long fcmId = fcmRepository.findOne(user,deviceType);
		fcmParam.setId(fcmId);
		
		return fcmRepository.save(fcmParam);
	}
	
	
	
}