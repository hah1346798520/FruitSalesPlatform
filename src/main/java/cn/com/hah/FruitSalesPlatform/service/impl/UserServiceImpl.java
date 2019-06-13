package cn.com.hah.FruitSalesPlatform.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.hah.FruitSalesPlatform.dao.UserDao;
import cn.com.hah.FruitSalesPlatform.entity.MyResult;
import cn.com.hah.FruitSalesPlatform.entity.User;
import cn.com.hah.FruitSalesPlatform.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	@Override
	@Transactional
	public void insert(User user) {
		userDao.insert(user);
	}
	@Override
	public MyResult<User> check(String username, String password) {
		MyResult<User> result =new MyResult<>();
		//result的status有三个状态值，0为账号错误，1为密码错误，2为登陆成功
		if(username==null||username==""||password==null||password=="") {
			//这里再次进行空值验证
			result.setStatus(0);
			result.setMsg("请输入账号和密码");
			return result;
		}
		User user=userDao.findUserByUsername(username);
		if(user==null) {
			result.setStatus(0);//与上面共用同一个状态值0
			result.setMsg("用户名不存在");
			return result;
		}else if(!password.equals(user.getPassword())) {
			result.setStatus(1);
			result.setMsg("密码错误");
			return result;
		}else {
			result.setStatus(2);
			result.setMsg("登陆成功");
			result.setData(user);
			return result;
		}
	}
	@Override
	public MyResult<User> check(User user) {
		//状态值0为失败，1为可以使用的用户名
		MyResult<User> result =new MyResult<>();
		if(user==null) {
			result.setStatus(0);
			result.setMsg("请输入用户名");
			return result;
		}
		//finduser为数据库中已经存在的用户
		User findUser=userDao.findUserByUsername(user.getUsername());
		if(findUser!=null) {
			//用户名已经存在
			result.setStatus(0);//与上面共用同一个状态值0
			result.setMsg("用户名已存在，请换一个用户名");
			return result;
		}else {
			//用户名可以使用
			result.setStatus(1);
			result.setMsg("注册成功!请登录");
			user.setUserid(UUID.randomUUID().toString().replace("-", ""));//为用户设置UUID主键
			userDao.insert(user);
			return result;
		}
	}

}
