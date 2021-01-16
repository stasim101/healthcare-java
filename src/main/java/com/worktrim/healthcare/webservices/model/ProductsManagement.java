package com.worktrim.healthcare.webservices.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="apc_modules_management")
public class ProductsManagement implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer apmt;

	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="PRODUCT_PRICE")
	private double productPrice;
	
	@Column(name="PRODUCT_STATUS")
	private String productStatus;
	
	@Column(name="SUBSCRIPTION_LENGTH")
	private int subscriptionLength;


	public Integer getApmt() {
		return apmt;
	}

	public void setApmt(Integer apmt) {
		this.apmt = apmt;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getSubscriptionLength() {
		return subscriptionLength;
	}

	public void setSubscriptionLength(int subscriptionLength) {
		this.subscriptionLength = subscriptionLength;
	}
	
	
	
	
	
}
