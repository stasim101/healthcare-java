package com.worktrim.healthcare.webservices.service.impl;


import com.worktrim.healthcare.webservices.dao.ProductsManagementdao;
import com.worktrim.healthcare.webservices.model.ProductsManagement;
import com.worktrim.healthcare.webservices.service.ProductsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("productsManagementServices")
@Transactional
public class ProductsManagementServiceImpl implements ProductsManagementService {

	@Autowired
	ProductsManagementdao dao;

	@Override
	public ProductsManagement findById(int apmt) {
		return dao.findById(apmt);
	}

	@Override
	public void saveProductsManagement(ProductsManagement product) {
	   dao.saveProductsManagement(product);
	}

	@Override
	public void updateProductsManagement(ProductsManagement product) {
		dao.updateProductsManagement(product);
	}

	@Override
	public void deleteProductsManagement(int apmt) {
	  dao.deleteProductsManagement(apmt);
		
	}

	@Override
	public List<ProductsManagement> findAllProducts() {
		return dao.findAllProducts();
	}
	
	
}
