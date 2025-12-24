package com.dailycodebuffer.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//Below is how we use variable value from external application.properties config
	@Value("${welcome.message}")
	private String WelcomeMessage;
	
	//@RequestMapping(value = "/", method=RequestMethod.GET)
	@GetMapping("/")
	public String helloWorld()
	{
		return WelcomeMessage;
	}

}
