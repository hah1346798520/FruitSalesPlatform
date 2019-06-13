package cn.com.hah.FruitSalesPlatform.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.hah.FruitSalesPlatform.dao.AccessoryDao;
import cn.com.hah.FruitSalesPlatform.entity.Accessory;
import cn.com.hah.FruitSalesPlatform.service.AccessoryService;
@Service
public class AccessoryServiceImpl implements AccessoryService {
	@Autowired
	AccessoryDao accessoryDao;
	
	@Override
	public List<Accessory> findByFruitId(String id) {
		return accessoryDao.findByFruitId(id);
	}

	@Override
	@Transactional
	public void insert(Accessory accessory) {
		accessory.setAccessoryId(UUID.randomUUID().toString().replace("-", ""));
		accessory.setCreateTime(new Date());
		accessoryDao.insert(accessory);
	}

	@Override
	@Transactional
	public void delete(String[] arrays) {
		for (String id : arrays) {
			accessoryDao.deleteByAccessoryId(id);
		}
	}

	@Override
	@Transactional
	public void deleteByFruitId(String id) {
		accessoryDao.deleteByFruitId(id);
	}

}
