package com.gamesrental.app.controllers.exceptions;

public class ControledException extends Exception	 {

	private static final long serialVersionUID = 1L;

	String message;

	public ControledException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
