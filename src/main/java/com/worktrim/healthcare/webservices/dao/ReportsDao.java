package com.worktrim.healthcare.webservices.dao;



import com.worktrim.healthcare.webservices.model.Reports;

import java.util.List;

public interface ReportsDao {
	

	Reports findById(int arid);
	
	void saveReports(Reports report);
	
	void updateReports(Reports report);
	
	void deleteReports(Reports report);
	

	List<Reports> findReportsByDateRangeForUser(String theStartDate, String theEndDate, String ssoId, String appName);
	List<Reports> findReportsSpecificDateForUser(String specificDate, String ssoId, String appName);
	
	List<Reports> findReportsByDateRangeForDepartment(String theStartDate, String theEndDate, int departmentID, String appName);
	List<Reports> findReportsSpecificDateForDepartment(String specificDate, int departmentID, String appName);
	
	List<Reports> findReportsByDateRangeForCompany(String theStartDate, String theEndDate, int apcId, String appName);
	List<Reports> findReportsSpecificDateForCompany(String specificDate, int apcid, String appName);
	
	
	List<Reports> findActivityTypeByUser(String theStartDate, String theEndDate, String ssoId, String activityType, String appName);
	List<Reports> findActivityTypeByDepartment(String theStartDate, String theEndDate, int depId, String activityType, String appName);
	List<Reports> findActivityTypeByCompany(String theStartDate, String theEndDate, int apcId, String activityType, String appName);
	
}
