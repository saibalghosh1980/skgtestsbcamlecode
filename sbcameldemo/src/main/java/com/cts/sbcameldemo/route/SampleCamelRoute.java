package com.cts.sbcameldemo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.cts.sbcameldemo.config.YamlConfigProperties;

@Component("springManagedSampleCamelRoute")
public class SampleCamelRoute extends RouteBuilder {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("springManagedYamlConfigProperties")
	YamlConfigProperties config;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer://foo?repeatCount=1").routeId("id_SampleRouteRoute")
				.log(LoggingLevel.INFO, logger, "Route started .....................................")
				.toD("https://reqres.in/api/users" + "?httpMethod=GET")
				.to("log:" + logger.getName() + "?level=INFO&showAll=true&multiline=true&showStreams=true");
		// TODO Auto-generated method stub
		from("direct:callsecondsvc").routeId("id_RouteSecondSvcCall")
				.log(LoggingLevel.INFO, logger, "Route started .....................................")
				.toD(config.getUrl()+"hello2/saibal" + "?httpMethod=GET")
				.to("log:" + logger.getName() + "?level=INFO&showAll=true&multiline=true&showStreams=true");

	}
}
