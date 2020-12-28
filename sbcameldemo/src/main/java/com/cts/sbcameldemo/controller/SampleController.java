package com.cts.sbcameldemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping(value = "/hello/{name}")
	public String sayHello(@PathVariable("name")String name) {
		logger.info("The input is : "+name);
		return "Hello "+name.toUpperCase();
	}

}
