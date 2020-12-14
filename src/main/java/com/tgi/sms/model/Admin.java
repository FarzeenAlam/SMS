package com.tgi.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Column(name="name")
	private String Name;
	
	@Id
	@Column(name="email")
	private String Email;
	
	@Column(name="password")
	private String Password;
	
	@Column(name="account_type")
	private String AccountType;

	public Admin() {
		super();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	@Override
	public String toString() {
		return "Admin [Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", AccountType=" + AccountType
				+ "]";
	}
	
	
}
