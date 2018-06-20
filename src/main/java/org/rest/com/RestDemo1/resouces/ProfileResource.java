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
import javax.ws.rs.core.MediaType;


import org.rest.com.RestDemo1.model.Profile;
import org.rest.com.RestDemo1.service.ProfileService;


@Path("/profiles")
public class ProfileResource {
	
	ProfileService profileService  = new ProfileService();
	
	/*this is for returning xml 
	@GET  @Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){ return messageService.getAllMessages();}
	*/
	
	// this is for returning JSON 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfiles(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName}") String profileName){
		 profileService.removeProfile(profileName);
	}
	
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	

}
