package com.casestudy.ContactApplication.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice //interceptor that surrounds the logic in our Controllers
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class) //Used for handling exceptions
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //reason for error that should be returned
	public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class) 
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> resourceNotFoundException(NotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateIdFoundException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<Object> resourceNotfoundException(DuplicateIdFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<Object> resourceNotFoundException(InvalidLoginException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(0), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionDetails, HttpStatus.CONFLICT);
	}
	
}
