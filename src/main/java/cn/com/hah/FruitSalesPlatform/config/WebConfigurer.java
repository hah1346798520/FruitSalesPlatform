package cn.com.hah.FruitSalesPlatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.com.hah.FruitSalesPlatform.config.intercepors.LoginInterceptor;
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] excludes=new String[] {"/js/**","/user/**"};
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludes);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
}
