package com.le.cameldemo;

import com.alibaba.fastjson.JSON;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRouter extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("kafka:test?brokers=127.0.0.1:9092&groupId=sss&autoOffsetReset=earliest")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Message message = exchange.getIn();
						String key = (String) message.getHeader(KafkaConstants.KEY,java.lang.String.class);
						String person = (String) message.getBody(String.class);
						Person personObj = JSON.parseObject(person,Person.class);
						message.setBody(personObj);
						exchange.setOut(message);
					}
				})
				.to("bean:reveiveBean?method=reveive")
				.end();
	}
}
