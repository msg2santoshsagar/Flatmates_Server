package com.alife.flatmates.server.domain.constants;

public class ApplicationConstants {
	
	public static final String KEY_APPLICATION_NAME  			= 	"applicationName";
	public static final String KEY_APPLICATION_VERSION  		= 	"applicationVersion";
	public static final String KEY_APPLICATION_RELEASE_DATE  	= 	"applicationReleaseDate";
	public static final String KEY_APPLICATION_SUB_VERISON 		= 	"applicationSubVersion";
	public static final String KEY_APPLICATION_UP_TIME  		= 	"applicationUpTime";
	
    public static final String LOGIN_REGEX 						=	 "^[_'.@A-Za-z0-9-]*$";

    private ApplicationConstants(){
    	// To not allow any other to create object
    }
    
}
