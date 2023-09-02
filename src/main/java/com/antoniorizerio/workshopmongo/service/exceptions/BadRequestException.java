package com.antoniorizerio.workshopmongo.service.exceptions;

public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 7766149870373259780L;
	
	public BadRequestException(String msg) {
		super(msg);
	}
}
