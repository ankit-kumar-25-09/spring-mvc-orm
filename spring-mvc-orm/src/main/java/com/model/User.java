package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@ApiModel(description="Details about the user")
public class User {
	@Id
	@GeneratedValue
	private int uid;
	private String userName;
	private String email;
	private String phone;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@ApiModelProperty("Address to be provided")
	private Address address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userName, String email, String phone, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
