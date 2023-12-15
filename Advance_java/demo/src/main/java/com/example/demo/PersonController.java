package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PersonController {
	

@GetMapping("person")
public String before()
{
		return "person";
}
@PostMapping("person")
public String afterSubmit(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("age") int age,Model model) 
{
	
	Person p=new Person();
	p.setName(name);
	p.setAddress(address);
	p.setAge(age);
	model.addAttribute("person", p);
	return "View";
}
}
