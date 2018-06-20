package org.rest.com.RestDemo1.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rest.com.RestDemo1.model.ErrorMessage;

//we can disable this annotation , we d
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	/*we have created this class because 
	* whenever the user enters the invalid url , the jax-rs must handle this exception before sending it 
	* to the server and must return the respone in the format of json not in the html/xml
	*/
	
	//this is just like catch all , whenever error occurs , this catches and returns this message 
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500,"http://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}
