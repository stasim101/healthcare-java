package com.worktrim.healthcare.webservices.service.impl;


import com.worktrim.healthcare.webservices.dao.UserDao;
import com.worktrim.healthcare.webservices.model.User;
import com.worktrim.healthcare.webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public List<User> findUsersByDepartment(String department_id) {
		return dao.findUsersByDepartment(department_id);
	}

	@Override
	public List<User> findUsersByDepartmentId(int department_id) {
		
		return dao.findUsersByDepartmentId(department_id);
	}

	@Override
	public List<User> findUsersByCompanyId(int companyId) {
		
		return dao.findUsersByCompanyId(companyId);
	}

	@Override
	public User findByUname(String uname) {
		
		return dao.findByUname(uname);
	}

	@Override
	public User findByPin(int pinNumber) {
		
		return dao.findByPin(pinNumber);
	}
	
}
