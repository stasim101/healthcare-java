package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.ReportsDao;
import com.worktrim.healthcare.webservices.model.Reports;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("reportsdataRepo")
@SuppressWarnings("unchecked")
public class ReportsDaoImpl extends AbstractDao<Integer, Reports> implements ReportsDao {
	

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public Reports findById(int arid) {
		
		Reports report = getByKey(arid);
		if(report!=null){
			Hibernate.initialize(report.getArid());
		}
		return report;
	}

	@Override
	public void saveReports(Reports report) {
		
		sessionfactory.getCurrentSession().save(report);
		
	}

	@Override
	public void updateReports(Reports report) {
		 sessionfactory.getCurrentSession().update(report);
		
	}

	@Override
	public void deleteReports(Reports report) {
		sessionfactory.getCurrentSession().delete(report);
		
	}

	@Override
	public List<Reports> findReportsByDateRangeForUser(String theStartDate, String theEndDate, String ssoId, String appName) {
		
		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND activity_date <= :endDate AND app_name = :appName AND ssoid = :user_ssoid ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("user_ssoid", ssoId)
				                                        .setParameter("appName", appName)
                                                        .list();
		return result;
		
	}

	@Override
	public List<Reports> findReportsSpecificDateForUser(String specificDate, String ssoId, String appName) {

		String hql = "FROM Reports  WHERE activity_date = :targetDate AND ssoid = :user_ssoid AND app_name = :appName";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("targetDate", specificDate)
				                                        .setParameter("user_ssoid", ssoId)
				                                        .setParameter("appName",appName)
                                                        .list();
		return result;
		
	}

	@Override
	public List<Reports> findReportsByDateRangeForDepartment(String theStartDate, String theEndDate, int departmentID, String appName) {

		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND activity_date <= :endDate AND app_name = :appName AND  dep_id = :depId ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("appName", appName)
				                                        .setParameter("depId", departmentID)
                                                        .list();
		return result;
	}

	@Override
	public List<Reports> findReportsSpecificDateForDepartment(String specificDate, int departmentID, String appName) {

		String hql = "FROM Reports  WHERE activity_date = :targetDate AND app_name = :appName AND dep_id = :depId";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("targetDate", specificDate)
				                                        .setParameter("depId", departmentID)
				                                        .setParameter("appName", appName)
                                                        .list();
		return result;
	}

	@Override
	public List<Reports> findReportsByDateRangeForCompany(String theStartDate, String theEndDate, int apcId, String appName) {
		
		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND app_name = :appName AND activity_date <= :endDate AND apc_id = :apcId ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("apcId", apcId)
				                                        .setParameter("appName", appName)
                                                        .list();
		return result;
		
	}

	@Override
	public List<Reports> findReportsSpecificDateForCompany(String specificDate, int apcid, String appName) {
	
		String hql = "FROM Reports  WHERE activity_date = :targetDate AND app_name = :appName AND apc_id = :apcId";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("targetDate", specificDate)
				                                        .setParameter("appName", appName)
				                                        .setParameter("apcId", apcid)
                                                        .list();
		return result;
	}

	@Override
	public List<Reports> findActivityTypeByUser(String theStartDate, String theEndDate, String ssoId, String activityType, String appName) {

		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND activity_date <= :endDate AND app_name = :appName AND ssoid = :ssoid AND activity_type = :activityName ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("appName", appName)
				                                        .setParameter("ssoid", ssoId)
				                                        .setParameter("activityName", activityType)
                                                        .list();
		return result;
	}

	@Override
	public List<Reports> findActivityTypeByDepartment(String theStartDate, String theEndDate, int depId, String activityType, String appName) {
		
		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND activity_date <= :endDate AND app_name = :appName AND  dep_id = :depId AND activity_type = :activityName ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("appName", appName)
				                                        .setParameter("depId", depId)
				                                        .setParameter("activityName", activityType)
                                                        .list();
		return result;
	}

	@Override
	public List<Reports> findActivityTypeByCompany(String theStartDate, String theEndDate, int apcId, String activityType, String appName) {
		
		String hql = "FROM Reports  WHERE activity_date >= :starteDate AND activity_date <= :endDate AND app_name = :appName AND  apc_id = :apcId AND activity_type = :activityName ORDER BY activity_date DESC";
		List<Reports> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("starteDate", theStartDate)
				                                        .setParameter("endDate", theEndDate)
				                                        .setParameter("appName", appName)
				                                        .setParameter("apcId", apcId)
				                                        .setParameter("activityName", activityType)
                                                        .list();
		return result;
	}

	
	

}
