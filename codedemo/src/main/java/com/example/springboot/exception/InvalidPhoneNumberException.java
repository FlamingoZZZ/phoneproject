package com.example.springboot.exception;

public class InvalidPhoneNumberException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}
