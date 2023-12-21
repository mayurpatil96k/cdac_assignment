package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController 
{
	@Value("${my.message}")
	private String message;
	
	@GetMapping("helloprofile")
	public String sayHello()
	{
		
		return message;
	}
}
