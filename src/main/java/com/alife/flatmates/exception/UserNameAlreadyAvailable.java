package com.alife.flatmates.exception;

public class UserNameAlreadyAvailable extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNameAlreadyAvailable() {
		super("User name is already registered with us.");
	}
	
	public UserNameAlreadyAvailable(String userName) {
		super("User name ["+userName+"] is already registered with us.");
	}
	
	
}
