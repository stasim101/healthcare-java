package com.worktrim.healthcare.webservices.dao.impl;


import com.worktrim.healthcare.webservices.dao.AbstractDao;
import com.worktrim.healthcare.webservices.dao.ProductsManagementdao;
import com.worktrim.healthcare.webservices.model.ProductsManagement;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings("unchecked")
@Repository("ProductsManagementdaoDataRepo")
public class ProductsManagementdaoImpl extends AbstractDao<Integer, ProductsManagement> implements ProductsManagementdao {
	

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public ProductsManagement findById(int apmt) {
		
		ProductsManagement prod = getByKey(apmt);
		if(prod!=null){
			Hibernate.initialize(prod.getApmt());
		}
		return prod;
	}

	@Override
	public void saveProductsManagement(ProductsManagement product) {
		sessionfactory.getCurrentSession().save(product);
		
	}

	@Override
	public void updateProductsManagement(ProductsManagement product) {
		sessionfactory.getCurrentSession().update(product);
		
	}

	@Override
	public void deleteProductsManagement(int apmt) {
		
		ProductsManagement prod= findById(apmt);
		delete(prod);
		
	}

	@Override
	public List<ProductsManagement> findAllProducts() {

		String hql = "FROM ProductsManagement";
		List<ProductsManagement> result = sessionfactory.getCurrentSession().createQuery(hql)
				                                        .list();
		return result;
	}


}
