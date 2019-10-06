package com.dhbw.jamsession.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NonResultException extends RuntimeException{

	private static final long serialVersionUID = 1L;
		
	public NonResultException(String msg) {
		super(msg);
	}
}
