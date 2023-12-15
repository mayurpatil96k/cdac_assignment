package com.example.fourth;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
@Controller
public class BookNewController
{

	// for welcome page "Home.html"

	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
	@GetMapping("book")
	public String before()
	{
		return "bookNew";
	}
	
	@PostMapping("book")
	public String afterSubmit(@RequestParam("bookname") String name,@RequestParam("price") long bookprice,Model model) 
	{
		Book book=new Book();
		book.setBookName(name);
		book.setPrice(bookprice);
		model.addAttribute("mb", book);
		return "success";
	}
}