package com.worktrim.healthcare.webservices.service.impl;

import com.worktrim.healthcare.webservices.dao.CompanyInformationdao;
import com.worktrim.healthcare.webservices.model.CompanyInformation;
import com.worktrim.healthcare.webservices.service.CompanyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("companyInformationService")
@Transactional
public class CompanyInformationServiceImpl implements CompanyInformationService {
	@Autowired
	CompanyInformationdao dao;

	@Override
	public CompanyInformation findById(int apcid) {
		return dao.findById(apcid);
	}

	@Override
	public void saveCompanyInformation(CompanyInformation companyInfo) {
		dao.saveCompanyInformation(companyInfo);
		
	}

	@Override
	public void updateCompanyInformation(CompanyInformation compnyInfo) {
	   dao.updateCompanyInformation(compnyInfo);
		
	}

	@Override
	public void deleteCompanyInformation(int apcid) {
		dao.deleteCompanyInformation(apcid);
		
	}

	@Override
	public CompanyInformation findCompanyByName(String companyName) {
		
		return dao.findCompanyByName(companyName);
	}

	@Override
	public List<CompanyInformation> findAllCompanies() {
		
		return dao.findAllCompanies();
	}

	
	

}
