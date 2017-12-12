package com.alife.flatmates.server.domain;

public class JsonResponse {
	
	private boolean success;
	private Object  result;
	private Object  error;
	
	public boolean isSuccess() {
		return success;
	}
	public JsonResponse setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public Object getResult() {
		return result;
	}
	public JsonResponse setResult(Object result) {
		this.result = result;
		return this;
	}
	public Object getError() {
		return error;
	}
	public JsonResponse setError(Object error) {
		this.error = error;
		return this;
	}
	
	@Override
	public String toString() {
		return "JsonResponse [success=" + success + ", result=" + result + ", error=" + error + "]";
	}
	

}
