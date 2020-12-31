package com.tgi.sms.mongo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class Admin {

	@Id
	private String id;

	private String email;
	private String password;
	private String name;
	private String account_type;

	public Admin() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", account_type="
				+ account_type + "]";
	}

}
