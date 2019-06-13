package cn.com.hah.FruitSalesPlatform.service;

import java.util.List;
import cn.com.hah.FruitSalesPlatform.entity.Retailer;
import cn.com.hah.FruitSalesPlatform.entity.RetailerMapper;

public interface RetailerService {
	public List<Retailer> find(RetailerMapper retailerMapper);

	public List<Retailer> findAll();
	
	public Retailer get(String id);
	
	public void update(Retailer retailer);
	
	public void deleteById(String id);
	
	public void insert(Retailer retailer);
}
