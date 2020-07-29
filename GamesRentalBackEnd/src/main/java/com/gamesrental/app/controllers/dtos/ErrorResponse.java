package com.gamesrental.app.controllers.dtos;

public class ErrorResponse {

	String message;

	String detail;
	
	public ErrorResponse(String message, String detail) {
		this.message = message;
		this.detail = detail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return detail;
	}

	public void setDetails(String detail) {
		this.detail = detail;
	}
	
}
