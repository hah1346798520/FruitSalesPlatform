package cn.com.hah.FruitSalesPlatform.service;

import cn.com.hah.FruitSalesPlatform.entity.MyResult;
import cn.com.hah.FruitSalesPlatform.entity.User;

public interface UserService {
	public User findUserByUsername(String username);

	public void insert(User user);

	public MyResult<User> check(String username, String password);
	
	public MyResult<User> check(User user);
	
	
	
}
