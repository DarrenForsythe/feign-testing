package com.darrenforsythe.feign.testing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

	private final BookServiceClient bookService;

	public LibraryController(BookServiceClient bookServiceClient) {
		this.bookService = bookServiceClient;
	}

	@GetMapping("/")
	String getLibrary(Model model) {
		model.addAttribute("msg", "Welcome to the Library");
		model.addAttribute("book", bookService.getBook());
		return "library";
	}

}