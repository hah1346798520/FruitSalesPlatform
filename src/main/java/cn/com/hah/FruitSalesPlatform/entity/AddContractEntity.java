package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class AddContractEntity implements Serializable {
	private int type;
	private String retailerId;
	private String[] commoditiesIdArrays;
	private String[] priceArrays;
	@Override
	public String toString() {
		return "AddContractEntity [type=" + type + ", retailerId=" + retailerId + ", commoditiesIdArrays="
				+ Arrays.toString(commoditiesIdArrays) + ", priceArrays=" + Arrays.toString(priceArrays) + "]";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public String[] getCommoditiesIdArrays() {
		return commoditiesIdArrays;
	}
	public void setCommoditiesIdArrays(String[] commoditiesIdArrays) {
		this.commoditiesIdArrays = commoditiesIdArrays;
	}
	public String[] getPriceArrays() {
		return priceArrays;
	}
	public void setPriceArrays(String[] priceArrays) {
		this.priceArrays = priceArrays;
	}
}
