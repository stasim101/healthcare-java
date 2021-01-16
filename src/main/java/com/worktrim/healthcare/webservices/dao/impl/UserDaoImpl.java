package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.UserDao;
import com.worktrim.healthcare.webservices.model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository("userDao")
@SuppressWarnings({"rawtypes","unchecked"})
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {


	@Autowired
	private SessionFactory sessionfactory;
	
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public User findById(int usid) {
		User user = getByKey(usid);
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	public User findBySSO(String sso) {
		
		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> entity = criteria.from(User.class);
		 criteria.select (entity); //Select all objects in user
		 criteria.where ( builder.equal( entity.get("ssoId"), sso ) );
		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		
		 User user;
		 try{ user  = (User) queryResult.getSingleResult(); }
		 catch (NoResultException nre){	user = null;}
		 
		 
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	 }

	public List<User> findAllUsers() {

		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> query = criteria.from(User.class);
		 criteria.select (query); //Select all objects in user
		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		
		 List<User> users;
		 try{ users  = queryResult.getResultList(); }
		 catch (NoResultException nre){	users = new ArrayList<User>();}
		 
		 
		return users;
	}


	@Override
	public List<User> findUsersByDepartment(String department_id) {
		String hql = "FROM User  WHERE department = :department_id";
		List result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("department_id", department_id)
				                                        .list();
		return result;
	}

	@Override
	public List<User> findUsersByDepartmentId(int department_id) {
		String hql = "FROM User  WHERE department_id = :department_id";
		List result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("department_id", department_id)
				                                        .list();
		return result;
	}

	@Override
	public List<User> findUsersByCompanyId(int companyId) {
		String hql = "FROM User  WHERE apc_id = :department_id";
		List result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("department_id", companyId)
				                                        .list();
		return result;
	}

	@Override
	public User findByUname(String uname) {
		
		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> query = criteria.from(User.class);
		
		 criteria.select (query); //Select all objects in user
		 criteria.where ( builder.equal( query.get("uname"), uname ) );

		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		 
		 User user;
		 try{ user  = (User) queryResult.getSingleResult(); }
		 catch (NoResultException nre){	user = null;}

		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	@Override
	public User findByPin(int pinNumber) {
		
		CriteriaBuilder builder = sessionfactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> query = criteria.from(User.class);
		
		 criteria.select (query); //Select all objects in user
		 criteria.where ( builder.equal( query.get("pin"), pinNumber ) );

		 Query queryResult = sessionfactory.getCurrentSession().createQuery(criteria);
		
		 User user;
		 try{ user  = (User) queryResult.getSingleResult(); }
		 catch (NoResultException nre){	user = null;}
		 
		 
		if(user!=null){
			Hibernate.initialize(user.getUserProfiles());
		}
		
		return user;
		
	}
	
	
	
}
