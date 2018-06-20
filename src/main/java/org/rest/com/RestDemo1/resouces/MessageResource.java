package org.rest.com.RestDemo1.resouces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.rest.com.RestDemo1.model.Message;
import org.rest.com.RestDemo1.service.MessageService;


@Path("/messages")
public class MessageResource {
	
	MessageService messageService  = new MessageService();
	
	/*this is for returning xml 
	@GET  @Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){ return messageService.getAllMessages();}
	*/
	
	// this is for returning JSON 
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}*/
	
	//episode:22(pagination & filtering)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size") int size){
		if(year >0){
			return messageService.getAllMessagesForYear(year);
		}
//		if(start>=0 && size>=0){
	//		return messageService.getAllMessagePaginated(start, size);
		//}
		return messageService.getAllMessages();
	}
	
	//this is cool, when the clients wants the response in the form of json ,the above method will be good
	//	but what if the client wants the response in the form of xml, we define the below method 
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessage(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size){
			if(year >0){
				return messageService.getAllMessagesForYear(year);
			}
			//if(start>=0 && size>=0){
				//return messageService.getAllMessagePaginated(start, size);
			//}
			return messageService.getAllMessages();
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessages(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
		 messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	// this  method is written to get the message by the id
	//public Message getMessages(@PathParam("messageId") long id){
		//return messageService.getMessage(id);
	//}
	
	//this method is written in episode:29(hateoas) 
	public Message getMessages(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		Message message = messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		return message; 
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
		.path(MessageResource.class)
		.path(Long.toString(message.getId()))
		.build()
		.toString();
		return uri;
	}
	
	
	@Path("/{messageId}/comments")  // episode:25(implementing sub resource) //http://localhost:8686/RestDemo1/webapi/messages/12/comments/12
	public CommentResource getCommentResource(){
		return new CommentResource();
	}

}
