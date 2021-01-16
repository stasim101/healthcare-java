package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.ClientModulesDao;
import com.worktrim.healthcare.webservices.model.ClientModules;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("clientModulesdaoDataRepo")
public class ClientsModulesDaoImpl extends AbstractDao<Integer, ClientModules> implements ClientModulesDao {
	

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public ClientModules findById(int prid) {
		ClientModules prod = getByKey(prid);
		if(prod!=null){
			Hibernate.initialize(prod.getPrid());
		}
		return prod;
	}

	@Override
	public void saveClientModules(ClientModules product) {
		sessionfactory.getCurrentSession().save(product);
		
	}

	@Override
	public void updateClientModules(ClientModules product) {
		sessionfactory.getCurrentSession().update(product);

	}

	@Override
	public void deleteClientModules(int prid) {
		ClientModules prod= findById(prid);
		sessionfactory.getCurrentSession().delete(prod);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientModules> findClientModulesByCompanyId(int companyId) {
		
		String hql = "FROM ClientModules  WHERE apc_id = :apcId";
		List<ClientModules> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .setParameter("apcId", companyId)
                                                        .list();
		return result;
	}


}
