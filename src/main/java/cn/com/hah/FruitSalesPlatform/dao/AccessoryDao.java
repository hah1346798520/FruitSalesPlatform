package cn.com.hah.FruitSalesPlatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.hah.FruitSalesPlatform.entity.Accessory;

@Mapper
public interface AccessoryDao {

	public List<Accessory> findByFruitId(String id);


	public void insert(Accessory accessory);


	public void deleteByAccessoryId(String id);

	public void deleteByFruitId(String id);
}
