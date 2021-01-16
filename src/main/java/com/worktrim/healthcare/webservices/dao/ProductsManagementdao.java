package com.worktrim.healthcare.webservices.dao;



import com.worktrim.healthcare.webservices.model.ProductsManagement;

import java.util.List;


public interface ProductsManagementdao {
	
	ProductsManagement findById(int apmt);
	
	void saveProductsManagement(ProductsManagement product); 
	
	void updateProductsManagement(ProductsManagement product);
	
	void deleteProductsManagement(int apmt);
	
	List<ProductsManagement> findAllProducts();

}
