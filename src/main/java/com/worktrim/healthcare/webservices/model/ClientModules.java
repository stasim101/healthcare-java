package com.worktrim.healthcare.webservices.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client_modules")
public class ClientModules implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer prid;

	
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="PRODUCT_PRICE")
	private double productPrice;
	
	@Column(name="APC_ID")
	private int appcentrusId;

	@Column(name="SUBSCRIPTION_LENGTH")
	private int subscriptionLength;

	@Column(name="CARD_EXPIRY")
	private String cardExpiry;
	
	@Column(name="CARD_LAST_FOUR")
	private String cardLastFour;
	
	@Column(name="AUTO_RENEWAL")
	private String autoRenewal;
   
	@Column(name="CUSTOMER_ID")
	private String customerId;
	
	@Column(name="SUBSCRIPTION_ID")
	private String subScriptionId;
	
	@Column(name="SCHEDULED_CANCELLATION_DATE")
	private String scheduledCancellationDate;
	
	@Column(name="NUM_USERS")
	private int numUsers;

	@Column(name="PAYMENT_METHOD")
	private String paymentMethod;
	
	@Column(name="EXPIRE_DATE")
	private String expireDate;

	@Column(name="ACTIVATION_DATE")
	private String activationDate;

	@Column(name="USAGE_STATUS")
	private String moduleStatus;
	
	
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
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


	public int getSubscriptionLength() {
		return subscriptionLength;
	}

	public void setSubscriptionLength(int subscriptionLength) {
		this.subscriptionLength = subscriptionLength;
	}

	public int getAppcentrusId() {
		return appcentrusId;
	}

	public void setAppcentrusId(int appcentrusId) {
		this.appcentrusId = appcentrusId;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCardLastFour() {
		return cardLastFour;
	}

	public void setCardLastFour(String cardLastFour) {
		this.cardLastFour = cardLastFour;
	}

	public String getAutoRenewal() {
		return autoRenewal;
	}

	public void setAutoRenewal(String autoRenewal) {
		this.autoRenewal = autoRenewal;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSubScriptionId() {
		return subScriptionId;
	}

	public void setSubScriptionId(String subScriptionId) {
		this.subScriptionId = subScriptionId;
	}

	
	public String getScheduledCancellationDate() {
		return scheduledCancellationDate;
	}

	public void setScheduledCancellationDate(String scheduledCancellationDate) {
		this.scheduledCancellationDate = scheduledCancellationDate;
	}

	public int getNumUsers() {
		return numUsers;
	}

	public void setNumUsers(int numUsers) {
		this.numUsers = numUsers;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getModuleStatus() {
		return moduleStatus;
	}

	public void setModuleStatus(String moduleStatus) {
		this.moduleStatus = moduleStatus;
	}
}
