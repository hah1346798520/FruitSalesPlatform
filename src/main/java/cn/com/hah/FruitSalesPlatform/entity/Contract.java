package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Contract implements Serializable {
	private String contractId;
	private String barCode;
	private int type;
	private Date createTime;
	private String retailerId;
	private List<CommoditiesVo> commoditiesList;
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public List<CommoditiesVo> getCommoditiesList() {
		return commoditiesList;
	}
	public void setCommoditiesList(List<CommoditiesVo> commoditiesList) {
		this.commoditiesList = commoditiesList;
	}
	
}
