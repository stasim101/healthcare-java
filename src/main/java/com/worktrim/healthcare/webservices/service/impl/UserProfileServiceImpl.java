package com.worktrim.healthcare.webservices.service.impl;


import com.worktrim.healthcare.webservices.dao.UserProfileDao;
import com.worktrim.healthcare.webservices.model.UserProfile;
import com.worktrim.healthcare.webservices.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDao dao;
	
	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
