package com.le.cameldemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.PrimitiveIterator;

@Component("myBean")
public class MyBean {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Value("hello world")
    private String say;

    public String saySomething() {
        System.out.println(say);

        producerTemplate.sendBody("direct:kafkaStart",new Person("lile","12","23"));
        return say;
    }



}
