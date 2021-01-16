package com.worktrim.healthcare.webservices.service;



import com.worktrim.healthcare.webservices.model.ClientModules;

import java.util.List;


public interface ClientModulesService {

     ClientModules findById(int prid);
	
	void saveClientModules(ClientModules product); 
	
	void updateClientModules(ClientModules product);
	
	void deleteClientModules(int prid);
	
	List<ClientModules> findClientModulesByCompanyId(int companyId);
}
