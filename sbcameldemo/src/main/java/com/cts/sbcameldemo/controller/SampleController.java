package com.cts.sbcameldemo.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbcameldemo.config.YamlConfigProperties;

@RestController
@RefreshScope
public class SampleController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("springManagedYamlConfigProperties")
	YamlConfigProperties config;

	@Autowired
	private CamelContext camelContext;
	@Autowired
	private ProducerTemplate producer;

	@GetMapping(value = "/hello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		logger.info("The input is : " + name + "--" + config.getTestEnvValue());
		final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).build();
		final Exchange responseExchange = producer.send("direct:callsecondsvc", requestExchange);
		return "Hello " + name.toUpperCase() + " from " + config.getTestEnvValue() + "---second call:"
				+ responseExchange.getMessage().getBody(String.class);
	}

}
