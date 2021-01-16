/*****************************************************************************************************
   Author: Kingsley Mbah
   Date : Jul 15, 2018, 4:39:00 AM

   This file is an integral part of worktrim and is owned and maintained by the
   aforementioned. Any copying and or distribution without prior authorization will prompt legal actions.
********************************************************************************************************/

package com.worktrim.healthcare.webservices.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_activity")

public class UserActivity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer uaid;
  
	
	@Column(name="EMPLOYEE_ID")
	private String employyeId;
	
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="LAST_ACTIVE")
	private String lastActive;
	
	@Column(name="PASSWORD_NEW")
	private String passwordUpdated;
	
	

	public String getPasswordUpdated() {
		return passwordUpdated;
	}

	public void setPasswordUpdated(String passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}

	public Integer getUaid() {
		return uaid;
	}

	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}

	public String getEmployyeId() {
		return employyeId;
	}

	public void setEmployyeId(String employyeId) {
		this.employyeId = employyeId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getLastActive() {
		return lastActive;
	}

	public void setLastActive(String lastActive) {
		this.lastActive = lastActive;
	}

	

}
