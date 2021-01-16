package com.worktrim.healthcare.webservices.service;



import com.worktrim.healthcare.webservices.model.UserProfile;

import java.util.List;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
