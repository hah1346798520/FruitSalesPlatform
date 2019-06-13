package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.util.Date;

public class Retailer implements Serializable{
	private String retailerId;
	private String name;
	private String telephone;
	private String address;
	private int status;
	private Date createTime;
	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", name=" + name + ", telephone=" + telephone + ", address="
				+ address + ", status=" + status + ", createTime=" + createTime + "]";
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}
