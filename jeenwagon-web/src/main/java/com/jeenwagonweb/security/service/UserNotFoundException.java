package com.jeenwagonweb.security.service;

public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5156928629249269009L;
	
	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(String message){
		super(message);
	}
	
	public UserNotFoundException(Throwable cause){
		super(cause);
	}
	
	public UserNotFoundException(String message,Throwable cause){
		super(message,cause);
	}
}