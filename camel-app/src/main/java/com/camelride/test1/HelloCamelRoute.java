package com.camelride.test1;

import org.apache.camel.builder.RouteBuilder;

public class HelloCamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("Hello camel my old friend");
		
	}

}
