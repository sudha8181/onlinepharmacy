package com.jsp.onlinepharmacy.exception;

public class StaffPasswordNotInvalidException extends RuntimeException {

private String message;
	
	public StaffPasswordNotInvalidException(String message) {
		super();
		this.message=message;
	}
}
