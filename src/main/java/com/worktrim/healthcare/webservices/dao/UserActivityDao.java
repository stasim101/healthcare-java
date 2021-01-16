
package com.worktrim.healthcare.webservices.dao;


import com.worktrim.healthcare.webservices.model.UserActivity;

public interface UserActivityDao {

    UserActivity findById(int uaid);
	
	void saveUserActivity(UserActivity activity);
	
	void updateUserActivity(UserActivity activity);
	
	void deleteUserActivity(int uaid);
	
	UserActivity findPreviousActiveDateTime(String empid);
	
	
	
}
