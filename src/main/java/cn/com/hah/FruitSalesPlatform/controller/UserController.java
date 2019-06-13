package cn.com.hah.FruitSalesPlatform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.hah.FruitSalesPlatform.entity.MyResult;
import cn.com.hah.FruitSalesPlatform.entity.User;
import cn.com.hah.FruitSalesPlatform.service.UserService;

@Controller
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/toLogin")
	public String toLogin() {
		return "login";//跳转至登陆页面
	}
	
	@RequestMapping("/user/toRegister")
	public String toRegister() {
		return "pages/register";//跳转至注册页面
	}
	
	@RequestMapping("/user/register")
	@ResponseBody
	public MyResult<User> register(User user) {
		return userService.check(user);
	}
	@RequestMapping("/user/login")
	@ResponseBody
	public MyResult<User> login(String username,String password,HttpSession session) {
		MyResult<User> result=userService.check(username,password);
		if(result.getStatus()==2) {
			//登陆成功
			session.setAttribute("user", result.getData());
		}
		return result;
	}
	
	@RequestMapping("/tohome")
	public String toHome() {
		return "home";//跳转至主页
	}
	
}
