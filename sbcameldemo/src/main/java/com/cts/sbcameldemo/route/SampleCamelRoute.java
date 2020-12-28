package com.cts.sbcameldemo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("springManagedSampleCamelRoute")
public class SampleCamelRoute extends RouteBuilder {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer://foo?repeatCount=100").routeId("id_SampleRouteRoute")
				.log(LoggingLevel.INFO, logger, "Route started .....................................")
				.toD("https://reqres.in/api/users" +
					    "?httpMethod=GET")
				.to("log:"+logger.getName()+"?level=INFO&showAll=true&multiline=true&showStreams=true");
				

	}
}
