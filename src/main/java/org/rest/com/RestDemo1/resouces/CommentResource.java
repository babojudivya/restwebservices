	package org.rest.com.RestDemo1.resouces;
	
	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	
	
	@Path("/")  // episode:25(implementing sub resource)
	public class CommentResource {
		
		@GET
		public String test(){
			return "new sub resource";
		}
		@GET
		@Path("/{commentId}")
		//public String test2(){
		
		//public String test2(@PathParam("commentId") long commentID){ 
		//we can also the access the parent level resources from this sub resource 
		// i.e we can accesss the message by id 
		
		public String test2(@PathParam("messageId") long messageID, @PathParam("commentId") long commentID){
			return "method to return comment ID:" +commentID+ "for messageID"+ messageID;
		}
		
	
	}
