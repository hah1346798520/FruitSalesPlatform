package cn.com.hah.FruitSalesPlatform.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import cn.com.hah.FruitSalesPlatform.entity.Retailer;
@Mapper
public interface RetailerDao {
	public List<Retailer> find(Retailer retailer);
	
	public Retailer get(String id);

	public void update(Retailer retailer);

	public List<Retailer> findAll();
	
	public void deleteById(String id);
	
	public void insert(Retailer retailer);
}
