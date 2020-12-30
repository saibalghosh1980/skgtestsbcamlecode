package com.cts.sbcameldemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@GetMapping(value = "/hello2/{name}")
	public String sayHello(@PathVariable("name")String name) {
		logger.info("The input is : "+name);
		return "Hello2 "+name.toUpperCase();
	}
}
