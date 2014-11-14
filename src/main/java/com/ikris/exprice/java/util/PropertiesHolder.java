package com.ikris.exprice.java.util;

import java.util.Properties;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;

public class PropertiesHolder extends PropertyResourceConfigurer{
	public static Properties properties;
	
	public static String getProperties(String key){
		return properties.getProperty(key);
	}
	
	public void sayHello(){
		System.out.println("Hello");
	}

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		properties = props;
		
	}

}
