package com.jsp.onlinepharmacy.exception;

public class AdminEmailNotValidException extends RuntimeException {

private String message;
	
	public AdminEmailNotValidException(String message) {
			super();
			this.message=message;
	}
}
