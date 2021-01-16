package com.worktrim.healthcare.webservices.dao;

import com.worktrim.healthcare.webservices.model.User;

import java.util.List;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	User findByUname(String uname);
	
	User findByPin(int pinNumber);

	List<User> findAllUsers();
	
	List<User> findUsersByDepartment(String department_id);
	
	List<User> findUsersByDepartmentId(int department_id);
	
	List<User> findUsersByCompanyId(int companyId);
	

}

