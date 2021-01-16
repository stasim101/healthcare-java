package com.worktrim.healthcare.webservices.service.impl;



import com.worktrim.healthcare.webservices.dao.ClientModulesDao;
import com.worktrim.healthcare.webservices.model.ClientModules;
import com.worktrim.healthcare.webservices.service.ClientModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clientModsServices")
@Transactional
public class ClientModulesServiceImpl implements ClientModulesService {
   
	@Autowired
	ClientModulesDao dao;

	@Override
	public ClientModules findById(int prid) {
		return dao.findById(prid);
	}

	@Override
	public void saveClientModules(ClientModules product) {
		dao.saveClientModules(product);
		
	}

	@Override
	public void updateClientModules(ClientModules product) {
		dao.updateClientModules(product);
		
	}

	@Override
	public void deleteClientModules(int prid) {
		dao.deleteClientModules(prid);
		
	}

	@Override
	public List<ClientModules> findClientModulesByCompanyId(int companyId) {
		
		return dao.findClientModulesByCompanyId(companyId);
	}
}