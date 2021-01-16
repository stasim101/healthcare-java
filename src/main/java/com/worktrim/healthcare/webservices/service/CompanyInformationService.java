package com.worktrim.healthcare.webservices.service;

import com.worktrim.healthcare.webservices.model.CompanyInformation;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


@CacheConfig(cacheNames={"companyInformationCache"})
public interface CompanyInformationService {
 
    
	@Cacheable
	CompanyInformation findById(int apcid);
	
	@CacheEvict(allEntries=true)
	void saveCompanyInformation(CompanyInformation companyInfo);
	
	@CacheEvict(allEntries=true)
	void updateCompanyInformation(CompanyInformation compnyInfo);
	
	@CacheEvict(allEntries=true)
	void deleteCompanyInformation(int apcid);
	
	@Cacheable
	CompanyInformation findCompanyByName(String companyName);
	
	@Cacheable
	List<CompanyInformation> findAllCompanies();
	
}
