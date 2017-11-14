package com.bfh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 自定义外部资源映射
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	//通过重写addResourceHandlers方法来自定义外部资源映射
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/upload/MusicPro/");
		super.addResourceHandlers(registry);
	}
}
