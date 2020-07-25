package com.sping5WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sping5WebApp.repositories.BookRepoository;

@Controller //tells spring the following method is a controller. 
public class BookController {
	
	private final BookRepoository bookRepoository;

	public BookController(BookRepoository bookRepoository) {
		this.bookRepoository = bookRepoository;
	}

	@RequestMapping("/books")  //maps the books view to webaddress
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepoository.findAll());
		return "books/list";
	}
		
}
