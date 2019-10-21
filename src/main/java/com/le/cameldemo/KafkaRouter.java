package com.le.cameldemo;

import com.alibaba.fastjson.JSON;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.util.ObjectHelper;
import org.springframework.stereotype.Component;


@Component
public class KafkaRouter extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("direct:kafkaStart")
				.setHeader(KafkaConstants.KEY,constant("kafkaTestKey"))
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Message message = exchange.getIn();
						Object obj = message.getBody();
						message.setBody(JSON.toJSONString(obj));
						exchange.setOut(message);
					}
				})
				.to("kafka:test?brokers=127.0.0.1:9092")
				.end();
	}
}
