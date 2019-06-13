package cn.com.hah.FruitSalesPlatform.service;

import java.util.List;

import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesMapper;

public interface CommoditiesService {
	public List<Commodities> find(CommoditiesMapper commoditiesMapper);

	public List<Commodities> findAll();
	
	public Commodities get(String id);
	
	public void update(Commodities commodities);
	
	public void deleteById(String id);
	
	public void insert(Commodities commodities);
}
