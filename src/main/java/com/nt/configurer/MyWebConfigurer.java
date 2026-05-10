package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptos.TimeCheckInterceptor;

@Component
public class MyWebConfigurer implements WebMvcConfigurer {

	@Autowired
	private TimeCheckInterceptor tci;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("MyWebConfigurer.addInterceptors()");
		registry.addInterceptor(tci);
	}

}
