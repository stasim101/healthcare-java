package com.worktrim.healthcare.webservices.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="apc_company_information")
public class CompanyInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer apcid;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="CREATED_DATE")
	private String createdDate;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_COUNTRY")
	private  String contactCountry;
	
	@Column(name="CONTACT_STATE")
	private String contactState;
	
	@Column(name="CONTACT_PHONE")
	private String contactPhone;
	
	@Column(name="CONTACT_FAX")
	private String contactFax;
	
	@Column(name="CONTACT_PERSON")
	private String contactPerson;
	
	@Column(name="ACCOUNT_STATUS")
	private String accountStatus;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	

	public Integer getApcid() {
		return apcid;
	}

	public void setApcid(Integer apcid) {
		this.apcid = apcid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactCountry() {
		return contactCountry;
	}

	public void setContactCountry(String contactCountry) {
		this.contactCountry = contactCountry;
	}

	public String getContactState() {
		return contactState;
	}

	public void setContactState(String contactState) {
		this.contactState = contactState;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactFax() {
		return contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	
	

}
