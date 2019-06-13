package cn.com.hah.FruitSalesPlatform.service;

import java.util.List;

import cn.com.hah.FruitSalesPlatform.entity.Accessory;

public interface AccessoryService {

	List<Accessory> findByFruitId(String id);


	void insert(Accessory accessory);

	void delete(String[] arrays);

	void deleteByFruitId(String id);
	
}
