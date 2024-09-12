package com.jsp.onlinepharmacy.exception;

import lombok.Getter;

@Getter
public class AdminPasswordNotValidException extends RuntimeException {
	
	private String message;
	
	public AdminPasswordNotValidException(String message) {
		super();
		this.message=message;
	}

}
