package com.worktrim.healthcare.webservices.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name="app_user")
@JsonIgnoreProperties(value = { "uname", "usid" })
public class User implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@JsonIgnore
	private Integer usid;

	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;

	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@Column(name="ACCOUNT_STATUS", nullable=false)
	private String accountStatus;

	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	@Column(name="OTHER_NAMES")
	private String otherNames;

	@Column(name="DOB")
	private String dob;

	@Column(name="EMAIL")
	private String email;

	@Column(name="PHONE")
	private String phone;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="CITY")
	private String city;

	@Column(name="STATE")
	private String state;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="DEPARTMENT_ID", nullable=false)
	private Integer departmentId;

	@Column(name="DATE_HIRED")
	private String dateHired;

	@Column(name="PROFILE_PHOTO")
	private String profilePhoto;

	@Column(name="APC_ID", nullable=false)
	private int apcId;

	@Column(name="UNAME" , unique=true, nullable=true)
	private String uname;

	@Column(name="PIN", unique=true, nullable=true)
	private int pin;

	@Column(name="ACCOUNT_CREATED_DATE")
	private String accountCreatedDate;

	@Column(name="ACCOUNT_IS_MASTER")
	private String accountIsMaster;

	@Transient
	private String departmentName;


	@Autowired
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "app_user_user_profile", //next table that holds  a field called user_id that is a FK to this entity.
			joinColumns = { @JoinColumn(name = "USER_ID") }, // field on the "app_user_user_profile" table that is mapped by FK to usid on this entity or table
			inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") }) // field on the "app_user_user_profile" table that is mapped by FK to 'id' on a third entity(user_profile) or table that holds the actual data.

	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();


	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public int getApcId() {
		return apcId;
	}

	public void setApcId(int apcId) {
		this.apcId = apcId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getAccountCreatedDate() {
		return accountCreatedDate;
	}

	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	public String getAccountIsMaster() {
		return accountIsMaster;
	}

	public void setAccountIsMaster(String accountIsMaster) {
		this.accountIsMaster = accountIsMaster;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
}
