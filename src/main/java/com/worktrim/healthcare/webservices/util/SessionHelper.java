package com.worktrim.healthcare.webservices.util;


import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.worktrim.healthcare.webservices.model.ClientModules;
import com.worktrim.healthcare.webservices.model.Reports;
import com.worktrim.healthcare.webservices.model.User;
import com.worktrim.healthcare.webservices.service.ClientModulesService;
import com.worktrim.healthcare.webservices.service.ReportsService;
import com.worktrim.healthcare.webservices.service.UserService;


@Service("usernfo")
public class SessionHelper {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TimeStamp timeStamp;
	@Autowired
	private ClientModulesService clientModulesService;
	@Autowired
	private ReportsService reportsService;


	@Value( "${apc.worktrim.healthcare.product.monthly.code}")
	private String healthcareMonthlySub;
	@Value( "${apc.worktrim.healthcare.product.aual.code}")
	private String healthcareAnualSub;

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */

	public  String getUsername(){
		String userName = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()){
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			userName = userDetails.getUsername();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	public boolean isAuthenticated() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.isAuthenticated();
	}

	/**
	 * This method returns  the apc id of the user.
	 */
	public int getApcid() {
		int apcid = 0;
		User currentUser = userService.findBySSO(getssoId());
		if(currentUser != null) {
			apcid = currentUser.getApcId();
		}
		return apcid;
	}



	public String getUserRole() {
		String userole = null;
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> roles =  authentication.getAuthorities();
		for (GrantedAuthority role : roles) {
			if(role.getAuthority().equals("ADMIN") || role.getAuthority().equals("EMPLOYEE")) {
				userole = role.getAuthority();
				break;
			}
		}

		if(!authentication.isAuthenticated()) {
			userole = "ANONYM";
		}

		return userole;
	}


	/**Return ssoId of the current user**/
	public String getssoId() {
		String ssoId = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.isAuthenticated()){
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			ssoId = userDetails.getPassword();
		}
		return ssoId;

	}




	public List<ClientModules> findClientsModule(){

		List<ClientModules> myModules =  clientModulesService.findClientModulesByCompanyId(getApcid());

		return myModules;
	}



	public ClientModules getThisModule(){

		List<ClientModules> myModules =  clientModulesService.findClientModulesByCompanyId(getApcid());
		ClientModules module = null;

		if(!myModules.isEmpty()) {
			for(ClientModules mod : myModules) {
				if(mod.getProductCode().equals(healthcareMonthlySub) || mod.getProductCode().equals(healthcareAnualSub)) {
					return mod;
				}
			}
		}
		return  module;
	}


	public int getNumberOfUsersInPlan() {
		ClientModules userModule = getThisModule();
		if(userModule != null) {
			return userModule.getNumUsers();
		}
		return 0;

	}


	public void saveReports(String reportType, String reportDescription, User user) {

		if (user != null && user.getSsoId() != null) {
			Reports activity = new Reports();
			activity.setSsoId(user.getSsoId());
			activity.setFirstName(user.getFirstName());
			activity.setLastName(user.getLastName());
			activity.setDepId(user.getDepartmentId());
			activity.setApcId(user.getApcId());
			activity.setActivityDate(timeStamp.getcurrentDate());
			activity.setActivityTime(timeStamp.getcurrentTime());
			activity.setActivityType(reportType);
			activity.setActivityDescription(reportDescription);
			activity.setAppName(Constants.REPORT_APP_NAME);
			reportsService.saveReports(activity);
		}


	}


	public User getcurrentUser() {
		User user = userService.findBySSO(getssoId());
		if(user != null) {
			return user;
		}
		return null;
	}
	
}
