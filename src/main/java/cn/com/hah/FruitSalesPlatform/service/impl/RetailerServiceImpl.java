package cn.com.hah.FruitSalesPlatform.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.hah.FruitSalesPlatform.dao.RetailerDao;
import cn.com.hah.FruitSalesPlatform.entity.Retailer;
import cn.com.hah.FruitSalesPlatform.entity.RetailerMapper;
import cn.com.hah.FruitSalesPlatform.service.RetailerService;
@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	RetailerDao retailerDao;
	public List<Retailer> find(RetailerMapper retailerMapper) {
		return retailerDao.find(retailerMapper);
	}
	public Retailer get(String id) {
		return retailerDao.get(id);
	}
	@Transactional
	public void update(Retailer retailer) {
		retailerDao.update(retailer);
	}
	public List<Retailer> findAll() {
		return retailerDao.findAll();
	}
	@Transactional
	public void deleteById(String id) {
		retailerDao.deleteById(id);
	}
	@Override
	@Transactional
	public void insert(Retailer retailer) {
		retailer.setRetailerId(UUID.randomUUID().toString().replace("-", ""));
		retailer.setCreateTime(new  Date());
		retailer.setStatus(1);
		retailerDao.insert(retailer);
	}

}
