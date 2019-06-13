package cn.com.hah.FruitSalesPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("cn.com.hah.FruitSalesPlatform")
public class FruitSalesPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitSalesPlatformApplication.class, args);
	}

}
