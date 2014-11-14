package com.ikris.exprice.java;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ikris.exprice.java.util.Constants;

@Service("SpringBizBean")
public class SpringBizBean {
	
	@PostConstruct
	public void init(){
		System.out.println(Constants.key1);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println(Constants.key2);
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
		SpringBizBean ph  = (SpringBizBean) ac.getBean("SpringBizBean");
//		DataSource ds = new 
	}
	
	
}
