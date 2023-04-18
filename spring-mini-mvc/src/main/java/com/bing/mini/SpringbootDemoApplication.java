package com.bing.mini;

import com.bing.mini.beans.BeansException;
import com.bing.mini.context.ClassPathXmlApplicationContext;
import com.bing.mini.test.service.OneService;
import com.bing.mini.test.service.TwoService;


public class SpringbootDemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", true);
		OneService oneService = null;
		TwoService twoService = null;
		try {
			oneService = (OneService)ctx.getBean("oneService");
			twoService = (TwoService)ctx.getBean("twoService");
		} catch (BeansException e) {
			e.printStackTrace();
		}
		oneService.sayHello();
		twoService.sayHello();
	}


}
