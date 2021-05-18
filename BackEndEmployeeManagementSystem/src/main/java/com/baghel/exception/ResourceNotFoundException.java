package com.baghel.exception;

public class ResourceNotFoundException extends RuntimeException {

	public static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
