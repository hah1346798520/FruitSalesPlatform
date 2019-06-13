package cn.com.hah.FruitSalesPlatform.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.com.hah.FruitSalesPlatform.entity.User;
@Mapper
public interface UserDao {
	public User findUserByUsername(String username);

	public void insert(User user);
}
