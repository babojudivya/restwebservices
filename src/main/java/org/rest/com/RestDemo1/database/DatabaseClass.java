package org.rest.com.RestDemo1.database;

import java.util.HashMap;
import java.util.Map;

import org.rest.com.RestDemo1.model.Message;
import org.rest.com.RestDemo1.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	
	public static Map<String ,Profile> getProfiles(){
		return profile;
	}
}
