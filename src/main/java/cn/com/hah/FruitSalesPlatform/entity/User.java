package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;
	private String userName;
	private String password;
	private String name;
	public String getUserId() {
		return userId;
	}
	public void setUserid(String userid) {
		this.userId = userid;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String telephone;
}
