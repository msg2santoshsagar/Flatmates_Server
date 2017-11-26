package com.alife.flatmates.FlatmatesServer.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alife.flatmates.FlatmatesServer.domain.constants.ApplicationConstants;
import com.alife.flatmates.FlatmatesServer.domain.constants.ApplicationDetailConstant;
import com.alife.flatmates.FlatmatesServer.util.DateUtil;

/**
 * A rest controller for providing application information detail.
 * 
 * @author   santosh sagar
 * @version  0.0.1
 * @since    26 Dec 2017
 *
 */
@RestController
@RequestMapping(value="/api")
public class ApplicationInformation {
	
	private Map<String, String> applicationInformationMap;
	
	/**
	 * It will help to initialize the value of applicationInformationMap
	 * It will automatically get invoked, when the class initialized.
	 */
	@PostConstruct
	private void init(){
		applicationInformationMap = new HashMap<>();
		applicationInformationMap.put(ApplicationConstants.KEY_APPLICATION_NAME, 			ApplicationDetailConstant.applicationName);
		applicationInformationMap.put(ApplicationConstants.KEY_APPLICATION_VERSION, 		ApplicationDetailConstant.applicationVersion);
		applicationInformationMap.put(ApplicationConstants.KEY_APPLICATION_RELEASE_DATE, 	ApplicationDetailConstant.applicationReleaseDate);
		applicationInformationMap.put(ApplicationConstants.KEY_APPLICATION_UP_TIME, 		DateUtil.getCurrentDate().toString());
	}
	
	/**
	 * Get  : /ping : to get application information detail
	 * Post : /ping : to get application information detail
	 * 
	 * @return a map which will have application detail
	 */
	@RequestMapping(value="/ping",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, String> ping(){
		return applicationInformationMap;
	}

}
