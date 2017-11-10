package com.bfh.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description shiro配置
 */
@Configuration
public class ShiroConfiguration {

	/*@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		hashedCredentialsMatcher.setHashIterations(1);
		return hashedCredentialsMatcher;
	}*/

	/*@Bean
	public EhCacheManager ehCacheManager(){
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
		return cacheManager;
	}*/

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator proxyCreator(){
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		return proxyCreator;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		LifecycleBeanPostProcessor lifecycleBeanPostProcessor = new LifecycleBeanPostProcessor();
		return lifecycleBeanPostProcessor;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);

		//拦截器
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();


//		filterChainDefinitionMap.put("/getSongs", "anon");
//		filterChainDefinitionMap.put("/css/**", "anon");
//		filterChainDefinitionMap.put("/fonts/**", "anon");
//		filterChainDefinitionMap.put("/images/**", "anon");
//		filterChainDefinitionMap.put("/js/**", "anon");
//		filterChainDefinitionMap.put("/music/**", "anon");
//
//		filterChainDefinitionMap.put("/", "anon");
//		filterChainDefinitionMap.put("/index", "anon");
//		filterChainDefinitionMap.put("/user/login", "anon");
//		filterChainDefinitionMap.put("/user/register", "anon");
//		filterChainDefinitionMap.put("/user/logout", "anon");



		//过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 :这是一个坑呢，一不小心代码就不好使了;
		//authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
		filterChainDefinitionMap.put("/**", "anon");

		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

		//身份认证失败，则跳转到登录页面的配置
		shiroFilter.setLoginUrl("/user/login");
		//权限认证失败，则跳转到指定页面
		shiroFilter.setUnauthorizedUrl("/user/login");
		//登录成功后要跳转的链接
		//shiroFilter.setSuccessUrl("/");

		return shiroFilter;
	}

	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm());
		//注意:开发时请先关闭，如不关闭热启动会报错
		//securityManager.setCacheManager(ehCacheManager());
		return securityManager;
	}

	@Bean
	public UserRealm userRealm(){
		UserRealm userRealm = new UserRealm();
		//userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return userRealm;
	}
}
