package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;

public class ContractDetail extends Contract implements Serializable {
	@Override
	public String toString() {
		return super.toString()+"ContractDetail [retailer=" + retailer + "]";
	}

	private Retailer retailer;

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
}
