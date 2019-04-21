package com.question.bank.questionbank.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8941622259763905337L;

	public ResourceNotFoundException(String message) {
		super(message);

	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);

	}
}
