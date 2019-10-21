package com.le.cameldemo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReveiveBean {

	public void reveive(Object o){
		Person person = (Person) o;

	}
}
