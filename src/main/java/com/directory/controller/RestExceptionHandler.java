package com.directory.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.directory.exception.ErrorResponse;
import com.directory.exception.ServiceException;
/**
 * @author R_Legend
 * This class is responsible to through Exception specified in Main controller.
 */
@ControllerAdvice
public class RestExceptionHandler {
	/**
	 * Exception for not appropriate directory
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponse> serviceExceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exception for bad URL
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage("The request could not be understood by the server due to invalid syntax.");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
