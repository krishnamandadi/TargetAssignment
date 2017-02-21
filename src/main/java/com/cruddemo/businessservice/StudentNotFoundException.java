package com.cruddemo.businessservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5149109998084102873L;

	public StudentNotFoundException(String id) {
		super("could not find student '" + id + "'.");
	}
}
