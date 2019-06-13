package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Commodities implements Serializable {
	@Override
	public String toString() {
		return "Commodities [fruitId=" + fruitId + ", fruitName=" + fruitName + ", price=" + price + ", locality="
				+ locality + ", createTime=" + createTime + "]";
	}
	private String fruitId;
	private String fruitName;
	private BigDecimal price;
	private String locality;
	private Date createTime;
	public String getFruitId() {
		return fruitId;
	}
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
