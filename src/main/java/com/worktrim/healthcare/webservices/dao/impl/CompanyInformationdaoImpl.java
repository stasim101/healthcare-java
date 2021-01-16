package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.CompanyInformationdao;
import com.worktrim.healthcare.webservices.model.CompanyInformation;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("companyInfoDataRepo")
public class CompanyInformationdaoImpl extends AbstractDao<Integer, CompanyInformation> implements CompanyInformationdao {
	

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public CompanyInformation findById(int apcid) {
		 CompanyInformation info = getByKey(apcid);
		if(info!=null){
			Hibernate.initialize(info.getApcid());
		}
		return info;
	}

	@Override
	public void saveCompanyInformation(CompanyInformation companyInfo) {
		sessionfactory.getCurrentSession().save(companyInfo);
		
	}

	@Override
	public void updateCompanyInformation(CompanyInformation compnyInfo) {
		sessionfactory.getCurrentSession().update(compnyInfo);
		
	}

	@Override
	public void deleteCompanyInformation(int apcid) {
		CompanyInformation info = findById(apcid);
		sessionfactory.getCurrentSession().delete(info);
		
	}

	@Override
	public CompanyInformation findCompanyByName(String companyName) {
		
		String hql = "FROM CompanyInformation WHERE  company_name = :compName";
		CompanyInformation results =  (CompanyInformation) sessionfactory.getCurrentSession().createQuery(hql)
				                                                                 .setParameter("compName", companyName)
		                                                                         .uniqueResult();
		return results;
		                        
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CompanyInformation> findAllCompanies() {

		String hql = "FROM CompanyInformation";
		List<CompanyInformation> results = sessionfactory.getCurrentSession().createQuery(hql) 
		                                                                     .list();
		return results;
	}


}
