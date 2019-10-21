package com.le.cameldemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private MyBean myBean;


	@RequestMapping("/test")
	public void test(){
		myBean.saySomething();
	}
}
