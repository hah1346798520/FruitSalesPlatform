package cn.com.hah.FruitSalesPlatform.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.hah.FruitSalesPlatform.dao.AccessoryDao;
import cn.com.hah.FruitSalesPlatform.dao.CommoditiesDao;
import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesMapper;
import cn.com.hah.FruitSalesPlatform.service.CommoditiesService;
@Service
public class CommoditiesServiceImpl implements CommoditiesService {
	@Autowired
	CommoditiesDao commoditiesDao;
	
	@Autowired
	AccessoryDao accessoryDao;
	
	public List<Commodities> find(CommoditiesMapper commoditiesMapper) {
		return commoditiesDao.find(commoditiesMapper);
	}
	public Commodities get(String id) {
		return commoditiesDao.get(id);
	}
	@Transactional
	public void update(Commodities commodities) {
		commoditiesDao.update(commodities);
	}
	public List<Commodities> findAll() {
		return commoditiesDao.findAll();
	}
	public void deleteById(String id) {
		commoditiesDao.deleteById(id);
		accessoryDao.deleteByFruitId(id);
	}
	@Transactional
	public void insert(Commodities commodities) {
		commodities.setFruitId(UUID.randomUUID().toString().replace("-", ""));
		commodities.setCreateTime(new Date());
		commoditiesDao.insert(commodities);
	}
}
