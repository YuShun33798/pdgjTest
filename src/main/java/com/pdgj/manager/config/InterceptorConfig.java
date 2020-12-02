package com.pdgj.manager.config;

import com.pdgj.manager.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {


	@Bean
	public AuthenticationInterceptor  authenticationInterceptor(){
		return new AuthenticationInterceptor();
	}

	/**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }

}
