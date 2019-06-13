package cn.com.hah.FruitSalesPlatform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.hah.FruitSalesPlatform.controller.UserController;
import cn.com.hah.FruitSalesPlatform.entity.MyResult;
import cn.com.hah.FruitSalesPlatform.entity.User;
import cn.com.hah.FruitSalesPlatform.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitSalesPlatformApplicationTests {

	
	@Autowired
	UserService userService;
	
	@Autowired
	UserController userController;
	@Test
	public void contextLoads() {
		String username="jack";
		String password="1234";
		MyResult<User> result=userController.login(username,password, null);
		User u=result.getData();
		System.out.println(result);
		System.out.println(u);
	
	}
	
	

}
