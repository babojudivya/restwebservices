package org.rest.com.RestDemo1.resouces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjectDemoResource {

		@GET
		@Path("annotations")  //http://localhost:8686/RestDemo1/webapi/injectdemo/annotations;param=value
		public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
											   @MatrixParam("authSessionID") String header,
											   @MatrixParam("name") String cookie){
			return "Matrix param:"+ matrixParam+ "Header Param;"+ header+"Cookie param"+cookie; 
	 
		}
		@GET
		@Path("Context")
		public String getParamsUsingContext(@Context UriInfo uriinfo, @Context HttpHeaders headers){
			String path = 
					
					uriinfo.getAbsolutePath().toString();
			String cookies = headers.getCookies().toString();
			return "path:"+ path+"cookies:"+cookies; 
		}
		
}
