package com.example.exp4;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
	private final BookRepository repository;
	
	public BookController(BookRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("books", repository.findAll());
		return "index";
	}
	
	@GetMapping("/new")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "bookForm";
	}
	
	@PostMapping("/save")
	public String saveBoook(@ModelAttribute Book book){
		repository.save(book);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable Long id, Model model) {
		Book book = repository.findById(id).orElse(null);
		if(book == null) {
			return "redirect:/";
		}
		model.addAttribute("book", book);
		return "bookForm";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}

}