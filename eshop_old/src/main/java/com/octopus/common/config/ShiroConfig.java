package com.octopus.common.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.octopus.common.userrealm.MyUserRealm;
import com.octopus.project.service.SysUserService;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
/**
 * shiro的权限基本控制和基础初始化配置
 * @author EDT灬谭泽豪
 *
 */

@Configuration
public class ShiroConfig {
/**
 * 实现shiro权限过滤
 */
	@Bean("shiroFilter")//bean注解告诉springboot这个方法会返回一个标准的bean
	public ShiroFilterFactoryBean getFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setUnauthorizedUrl("/sys/toLogin");
		bean.setLoginUrl("/sys/toLogin");//设定登陆地址,鉴权错误或者没有授权访问时自动跳转到该请求
		//权限的全局设置
		Map<String, String> auths = new HashMap<>();
		auths.put("/sys/toLogin","anon");//如果一个地址不需要权限访问，则设置为anno
		auths.put("/sys/doLogin","anon");
		auths.put("/project/sysRole/**","authc");//需要授权
		auths.put("/**","authc");//其他必须授权
		//静态资源的路径要能直接访问
		auths.put("/css/**","anon");
		auths.put("/fonts/**","anon");
		auths.put("/js/**","anon");
		bean.setFilterChainDefinitionMap(auths);
		return bean;
	}
	
	@Bean
	public SecurityManager securityManager(MyUserRealm myUserRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myUserRealm);
		return securityManager;
	}
	
	@Bean
	public MyUserRealm mUserRealm(SysUserService userService) {
		MyUserRealm userRealm = new MyUserRealm();
		//进行一系列的操作比如注入属性
		userRealm.setUserService(userService);
		
		return userRealm;
	}
	/**
	 * 让shiro参与到spring的bean的管理中来
	 * @return
	 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	/**
	 * 扫描所有的bean寻找通知并将通知器所切入bean中
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return  creator;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor attributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
}
