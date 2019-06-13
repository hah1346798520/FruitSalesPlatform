package cn.com.hah.FruitSalesPlatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesMapper;
@Mapper
public interface CommoditiesDao {
	public List<Commodities> find(CommoditiesMapper commoditiesMapper);
	
	public Commodities get(String id);

	public void update(Commodities commodities);

	public List<Commodities> findAll();
	
	public void deleteById(String id);
	
	public void insert(Commodities commodities);
}
