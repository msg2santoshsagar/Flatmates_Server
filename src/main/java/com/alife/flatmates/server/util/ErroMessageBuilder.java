package com.alife.flatmates.server.util;

import java.util.HashMap;
import java.util.Map;

public class ErroMessageBuilder {

	private ErroMessageBuilder() {
		// Private constructor
	}

	public static Object createErrorMessage(Exception ex) {

		Map<String, String> map = new HashMap<>();

		String exceptionType   = ex.getClass().getSimpleName();

		map.put("exceptionType"		, 	exceptionType);
		map.put("exceptionMessage"  ,   ex.getMessage());


		if(exceptionType.equals("UserNameAlreadyAvailable")){
			
			map.put("code", "1001");
			map.put("message", "User Name is already registered.");
			
		}else if(exceptionType.equals("EmailAlreadyAvailable")){
			
			map.put("code", "1002");
			map.put("message", "Email id is already registered.");
			
		}else{
			
			map.put("code"				, 	"1000");
			map.put("message"           , "An Unknown exception occured");
			
		}


		return map;
	}

}
