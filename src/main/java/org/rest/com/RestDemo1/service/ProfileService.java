package org.rest.com.RestDemo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.com.RestDemo1.database.DatabaseClass;
import org.rest.com.RestDemo1.model.Message;
import org.rest.com.RestDemo1.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("kishore",new Profile(1L,"kishore","shiva","maroju"));
		profiles.put("koushik",new Profile(2L,"javabrains","koushik","kothagal"));
	}
	
	public List<Profile> getAllProfiles(){
		/*Message m1 = new Message(1L,"hellowolrd","kishore");Message m2= new Message(2L,"hello Jersey","koushik");
		List<Message> list  = new ArrayList<>(); list.add(m1); list.add(m2); return list;*/	
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName); 
	}
	

}
