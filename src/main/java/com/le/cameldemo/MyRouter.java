package com.le.cameldemo;

import org.apache.camel.DynamicRouter;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouter extends RouteBuilder {


	@Override
	public void configure() throws Exception {
//		System.out.println("camel start");
//		from("timer:hello?period={{timer.period}}").routeId("hello")
//				.transform().method("myBean","saySomething")
//				.filter(simple("${body} contains 'foo'"))
//                    .to("log:foo")
//				.end()
//					.to("stream:out");
	}
}
