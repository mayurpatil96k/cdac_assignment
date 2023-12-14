package mypack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class BookNewController
{
	@GetMapping("book")
	public String before()
	{
 		return "bookNew";
	}
	
	@PostMapping("book")
	public String afterSubmit(@RequestParam("bname") String name,@RequestParam("price") long bookprice,Model model) 
	{
		Book book=new Book();
		book.setBookName(name);
		book.setPrice(bookprice);
		model.addAttribute("mybook", book);
		return "success";
	}
}