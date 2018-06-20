package org.rest.com.RestDemo1.exception;

public class DataNotFoundException extends RuntimeException{
	
	//episode:27 handling the exceptions in jax-rs

	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		super(message); 
	}
	
	

}
