package com.alife.flatmates.server.util;

import com.alife.flatmates.server.domain.JsonResponse;

public class JsonResponseBuilder {
	
	private JsonResponseBuilder() {
		// Private constructor
	}
	
	public static Object creatBasicJsonResponse(boolean isSuccess, Object data, Exception ex ){
		
		JsonResponse jsonResponse = new JsonResponse().setSuccess(isSuccess);
		if(isSuccess){
			jsonResponse.setResult(data);
		}else{
			jsonResponse.setError(ErroMessageBuilder.createErrorMessage(ex));
		}
		return jsonResponse;
		
	}
	
	
	
	

}
