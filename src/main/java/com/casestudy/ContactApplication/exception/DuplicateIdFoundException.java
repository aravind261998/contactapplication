package com.casestudy.ContactApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateIdFoundException extends RuntimeException {

	public DuplicateIdFoundException() {
		super();
	}
	
	public DuplicateIdFoundException(String msg) {
		super(msg);
	}
}
