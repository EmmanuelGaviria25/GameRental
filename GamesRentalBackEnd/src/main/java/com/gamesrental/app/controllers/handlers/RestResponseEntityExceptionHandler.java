package com.gamesrental.app.controllers.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gamesrental.app.controllers.dtos.ErrorResponse;
import com.gamesrental.app.controllers.exceptions.ControledException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder detailsError = new StringBuilder();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			detailsError.append("- ").append(error.getDefaultMessage());
			detailsError.append("\n");
        }
		ErrorResponse error = new ErrorResponse("Validation Failed", detailsError.toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ControledException.class)
	protected ResponseEntity<ErrorResponse> handleError(ControledException ex) {
		ErrorResponse error = new ErrorResponse("Failed Request", ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<ErrorResponse> handleError(Exception ex) {
		ErrorResponse error = new ErrorResponse("Server Error", ex.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}