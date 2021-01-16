package com.worktrim.healthcare.webservices.dao;




import com.worktrim.healthcare.webservices.model.CompanyInformation;

import java.util.List;


public interface CompanyInformationdao {

	
	CompanyInformation findById(int apcid);
	
	void saveCompanyInformation(CompanyInformation companyInfo);
	
	void updateCompanyInformation(CompanyInformation compnyInfo);
	
	void deleteCompanyInformation(int apcid);
	
	CompanyInformation findCompanyByName(String companyName);
	
	List<CompanyInformation> findAllCompanies();
	
}
