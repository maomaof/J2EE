package com.pbz.demo.hello.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = -1886558013338449116L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}
}
