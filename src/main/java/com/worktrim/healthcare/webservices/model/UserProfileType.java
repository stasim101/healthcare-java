package com.worktrim.healthcare.webservices.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	EMPLOYEE("EMPLOYEE"),
	INTERNAL("INTERNAL"),
	ACCOUNTMANAGER("ACCOUNTMANAGER"),
	HEALTH("HEALTH"),
	NURSINGASSISTANT("NURSINGASSISTANT"),
	REPORT("REPORT"),
	SCHEDULER("SCHEDULER"),
	TIMECLOCKMANAGER("TIMECLOCKMANAGER"),
	USERMANAGER("USERMANAGER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
