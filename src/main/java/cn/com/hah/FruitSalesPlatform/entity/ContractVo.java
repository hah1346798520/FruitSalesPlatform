package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.util.Date;

public class ContractVo implements Serializable {
	private String contractId;
	private String barCode;
	private String retailerName;
	private int type;
	private Date createTime;
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
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
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
	@Override
	public String toString() {
		return "ContractVo [contractId=" + contractId + ", barCode=" + barCode + ", retailerName=" + retailerName
				+ ", type=" + type + ", createTime=" + createTime + "]";
	}
	
}
