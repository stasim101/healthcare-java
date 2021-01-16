package com.worktrim.healthcare.webservices.dao.impl;

import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.UserProfileDao;
import com.worktrim.healthcare.webservices.model.UserProfile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {


	@Autowired
	private SessionFactory sessionfactory;
	
	public UserProfile findById(int id) {
		return getByKey(id);
	}

	public UserProfile findByType(String type) {
		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteria = builder.createQuery(UserProfile.class);
		Root<UserProfile> query = criteria.from(UserProfile.class);
		 criteria.select (query); //Select all objects in Profile
		 criteria.where ( builder.equal( query.get("type"), type ) );
		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		 
		 
		 UserProfile profile;
		 try{ profile  = (UserProfile) queryResult.getSingleResult(); }
		 catch (NoResultException nre){	profile = null;}
		 
		 
		return profile;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll(){
		
		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteria = builder.createQuery(UserProfile.class);
		Root<UserProfile> query = criteria.from(UserProfile.class);
		 criteria.select (query); //Select all objects in user
		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		
		 List<UserProfile> roles;
		 try{ roles  = queryResult.getResultList(); }
		 catch (NoResultException nre){	roles = null;}
		 
		 
		return roles;
		
	}
	
}
