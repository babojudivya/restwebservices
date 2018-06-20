package org.rest.com.RestDemo1.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rest.com.RestDemo1.model.ErrorMessage;

@Provider

	public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	/*the exception should be raised in the form of the json format, not simply in the text/html formats. 
	* so we have developed this class as per the episode:27 handling the exceptions in jax-rs
	*/
	
	
	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"http://www.google.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
