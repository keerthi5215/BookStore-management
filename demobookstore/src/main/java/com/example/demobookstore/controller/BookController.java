package com.example.demobookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demobookstore.model.*;

import com.example.demobookstore.service.*;


import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
		return new ModelAndView("bookList","book",list);
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=MyBookListService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		MyBookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
	
}
	