package com.alife.flatmates.exception;

public class EmailAlreadyAvailable extends Exception {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyAvailable() {
		super("Email id is already registered with us.");
	}
	
	public EmailAlreadyAvailable(String emailId) {
		super("Email id ["+emailId+"] is already registered with us.");
	}
	
	
}
