package com.worktrim.healthcare.webservices.service;

import com.worktrim.healthcare.webservices.model.User;

import java.util.List;

public interface UserService {
	
	
	User findById(int id);
 
	
	User findBySSO(String sso);
	
	
	User findByUname(String uname);
	
	
	User findByPin(int pinNumber);
	

	List<User> findAllUsers();

	List<User> findUsersByDepartment(String departmenId);
	
	List<User> findUsersByDepartmentId(int departmentId);
	
	
	List<User> findUsersByCompanyId(int companyId);
	
	
	
}