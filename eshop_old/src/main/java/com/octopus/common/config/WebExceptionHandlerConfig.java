package com.octopus.common.config;

import java.util.Properties;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 
 * 配置web环境中出现异常时如何解决不同异常跳转到不同页面的方法
 *
 */
@Configuration
public class WebExceptionHandlerConfig {
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties props = new Properties();
		//让特定的异常类型和特定的页面对应起来，第二个参数是页面的名称
		props.put("org.apache.shiro.authz.UnauthorizedException", "/unauthor");
		resolver.setExceptionMappings(props);
		return resolver;
	}
}
