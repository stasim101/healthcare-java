
package com.worktrim.healthcare.webservices.service;


import com.worktrim.healthcare.webservices.model.UserActivity;

public interface UserActivityService {
     

    UserActivity findById(int uaid);
	
  
	void saveUserActivity(UserActivity activity);
	

	void updateUserActivity(UserActivity activity);
	
 
	void deleteUserActivity(int uaid);
	
  
	UserActivity findPreviousActiveDateTime(String empid);
}
