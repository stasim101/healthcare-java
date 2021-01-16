package com.worktrim.healthcare.webservices.service.impl;


import com.worktrim.healthcare.webservices.dao.ReportsDao;
import com.worktrim.healthcare.webservices.model.Reports;
import com.worktrim.healthcare.webservices.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("reportsDataServiceLayer")
@Transactional
public class ReportsServiceImpl implements ReportsService {
   
	@Autowired
	ReportsDao dao;

	@Override
	public Reports findById(int arid) {
		return dao.findById(arid);
	}

	@Override
	public void saveReports(Reports report) {
		dao.saveReports(report);
		
	}

	@Override
	public void updateReports(Reports report) {
		dao.updateReports(report);
	}

	@Override
	public void deleteReports(Reports report) {
		dao.deleteReports(report);
		
	}

	@Override
	public List<Reports> findReportsByDateRangeForUser(String theStartDate, String theEndDate, String ssoId, String appName) {
		return dao.findReportsByDateRangeForUser(theStartDate, theEndDate, ssoId, appName);
	}

	@Override
	public List<Reports> findReportsSpecificDateForUser(String specificDate, String ssoId, String appName) {
		return dao.findReportsSpecificDateForUser(specificDate, ssoId, appName);
	}

	@Override
	public List<Reports> findReportsByDateRangeForDepartment(String theStartDate, String theEndDate, int departmentID, String appName) {
		return dao.findReportsByDateRangeForDepartment(theStartDate, theEndDate, departmentID, appName);
	}

	@Override
	public List<Reports> findReportsSpecificDateForDepartment(String specificDate, int departmentID, String appName) {

		return dao.findReportsSpecificDateForDepartment(specificDate, departmentID, appName);
	}

	@Override
	public List<Reports> findReportsByDateRangeForCompany(String theStartDate, String theEndDate, int apcId, String appName) {
	
		return dao.findReportsByDateRangeForCompany(theStartDate, theEndDate, apcId, appName);
	}

	@Override
	public List<Reports> findReportsSpecificDateForCompany(String specificDate, int apcid, String appName) {
		return dao.findReportsSpecificDateForCompany(specificDate, apcid, appName);
	}

	@Override
	public List<Reports> findActivityTypeByUser(String theStartDate, String theEndDate, String ssoId, String activityType, String appName) {
		return dao.findActivityTypeByUser(theStartDate, theEndDate, ssoId, activityType, appName);
	}

	@Override
	public List<Reports> findActivityTypeByDepartment(String theStartDate, String theEndDate, int depId, String activityType, String appName) {
		return dao.findActivityTypeByDepartment(theStartDate, theEndDate, depId, activityType, appName);
	}

	@Override
	public List<Reports> findActivityTypeByCompany(String theStartDate, String theEndDate, int apcId, String activityType, String appName) {
		return dao.findActivityTypeByCompany(theStartDate, theEndDate, apcId, activityType, appName);
	}


}
