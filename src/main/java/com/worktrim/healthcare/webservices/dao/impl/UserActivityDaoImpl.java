
package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.UserActivityDao;
import com.worktrim.healthcare.webservices.model.UserActivity;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository("userActivityRepo")
public class UserActivityDaoImpl extends AbstractDao<Integer, UserActivity> implements UserActivityDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Override
	public UserActivity findById(int uaid) {
		UserActivity activity = getByKey(uaid);
		
		if(activity!=null){
			Hibernate.initialize(activity.getUaid());

		}
		return activity;
	}

	@Override
	public void saveUserActivity(UserActivity activity) {
		 sessionfactory.getCurrentSession().save(activity);
		
	}

	@Override
	public void updateUserActivity(UserActivity activity) {
	sessionfactory.getCurrentSession().update(activity);
		
	}

	@Override
	public void deleteUserActivity(int uaid) {
		
		UserActivity activity= findById(uaid);
		delete(activity);
		
	}

	@Override
	public UserActivity findPreviousActiveDateTime(String empid) {

		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<UserActivity> criteria = builder.createQuery(UserActivity.class);
		Root<UserActivity> entity = criteria.from(UserActivity.class);
		 criteria.select (entity); //Select all objects 
		 criteria.where ( builder.equal( entity.get("employyeId"), empid ) );
		 criteria.orderBy(builder.desc(entity.get("uaid"))); // add order by
		 
		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		
		 List activity  = queryResult.getResultList();
		 UserActivity finalActivity = new UserActivity();
		 if(!activity.isEmpty()) {
			finalActivity = (UserActivity) activity.get(0);
		 }
		 
		 
		 return finalActivity;
		
		
		
		
	}

}
