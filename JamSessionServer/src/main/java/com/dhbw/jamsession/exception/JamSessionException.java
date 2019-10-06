package com.dhbw.jamsession.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JamSessionException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public JamSessionException(String msg) {
		super(msg);
	}
}
