package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Accessory implements Serializable {
	private String accessoryId;
	private String fruitId;
	private String name;
	private BigDecimal price;
	private Date createTime;
	@Override
	public String toString() {
		return "Accessory [accessoryId=" + accessoryId + ", fruitId=" + fruitId + ", name=" + name + ", price=" + price
				+ ", createTime=" + createTime + "]";
	}
	public String getAccessoryId() {
		return accessoryId;
	}
	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}
	public String getFruitId() {
		return fruitId;
	}
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
