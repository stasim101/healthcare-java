/*****************************************************************************************************
   Author: Kingsley Mbah
   Date : Jul 15, 2018, 5:11:25 AM

   This file is an integral part of worktrim and is owned and maintained by the
   aforementioned. Any copying and or distribution without prior authorization will prompt legal actions.
********************************************************************************************************/

package com.worktrim.healthcare.webservices.service.impl;


import com.worktrim.healthcare.webservices.dao.UserActivityDao;
import com.worktrim.healthcare.webservices.model.UserActivity;
import com.worktrim.healthcare.webservices.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userActivityservice")
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao dao;
	
	@Override
	public UserActivity findById(int uaid) {
		
		return dao.findById(uaid);
	}

	@Override
	public void saveUserActivity(UserActivity activity) {
		dao.saveUserActivity(activity);
		
	}

	@Override
	public void updateUserActivity(UserActivity activity) {
		dao.updateUserActivity(activity);
		
	}

	@Override
	public void deleteUserActivity(int uaid) {
		dao.deleteUserActivity(uaid);
		
	}

	@Override
	public UserActivity findPreviousActiveDateTime(String empid) {
	
		return dao.findPreviousActiveDateTime(empid);
	}

}
