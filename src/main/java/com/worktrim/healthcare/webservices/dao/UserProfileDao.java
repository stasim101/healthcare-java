package com.worktrim.healthcare.webservices.dao;


import com.worktrim.healthcare.webservices.model.UserProfile;

import java.util.List;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
