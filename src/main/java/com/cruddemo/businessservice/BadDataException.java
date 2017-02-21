package com.cruddemo.businessservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDataException extends RuntimeException {

	private static final long serialVersionUID = -7278587684690065092L;

	public BadDataException(String message) {
		super(message);
	}
}
