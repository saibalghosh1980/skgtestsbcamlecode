package com.cts.sbcameldemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbcameldemo.config.YamlConfigProperties;

@RestController
public class SampleController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("springManagedYamlConfigProperties")
	YamlConfigProperties config;
	
	@GetMapping(value = "/hello/{name}")
	public String sayHello(@PathVariable("name")String name) {
		logger.info("The input is : "+name+"--"+config.getTestEnvValue());
		return "Hello "+name.toUpperCase()+" from "+config.getTestEnvValue();
	}

}
