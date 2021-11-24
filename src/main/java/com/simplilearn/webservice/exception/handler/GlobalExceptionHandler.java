package com.simplilearn.webservice.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.webservice.exception.InvalidProductException;
import com.simplilearn.webservice.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(ProductNotFoundException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidProductException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidProductException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(),
				HttpStatus.BAD_REQUEST.name(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
