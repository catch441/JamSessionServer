package com.dhbw.jamsession.sl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {
	
	private static ApplicationContext context;
	
	@Autowired
	ApplicationContext staticContext;
	
	@PostConstruct
    public void init() {
		ServiceManager.context = staticContext;
    }

	public static <T> T getService(Class<T> serviceInterface) {
		return context.getBean(serviceInterface);
	}
	
}
