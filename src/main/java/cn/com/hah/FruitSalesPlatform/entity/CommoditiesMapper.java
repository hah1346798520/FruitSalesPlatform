package cn.com.hah.FruitSalesPlatform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CommoditiesMapper extends Commodities implements Serializable {
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private Date startTime;
	private Date endTime;
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
