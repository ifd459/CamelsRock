package com.camelride.test4;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class TileToActiveMQ {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:input_box?noop=true")
				.log(LoggingLevel.INFO, "komt ie hierrr???")
//				.process(new Processor() {
//					
//					public void process(Exchange exchange) throws Exception {
//						System.out.println(" hier daaannnn");
//					}
//				})
				.log(LoggingLevel.INFO, "${body}")
				.to("activemq:queue:my_queue");
			}
		});
		while(true)
		context.start();
	}

}
