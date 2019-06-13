package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.util.List;

public class CommoditiesVo extends Commodities implements Serializable{
	private int number;
	private List<Accessory> accessoryList;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}
	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}
}
