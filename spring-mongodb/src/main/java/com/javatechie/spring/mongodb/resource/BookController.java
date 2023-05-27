package com.javatechie.spring.mongodb.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongodb.model.Book;
import com.javatechie.spring.mongodb.repo.BookRepo;

@RestController
@RequestMapping("/springmongo")
public class BookController {

	@Autowired
	private BookRepo bookRepo;
	
	@PostMapping("/addBook")
	public String saveBook (@RequestBody Book book) {
		
		bookRepo.save(book);
		return "Added book: " + book.getId() + " successfully!";
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
	}
	
	@GetMapping("/getBookById/{id}")
	public Optional<Book> findByBookId(@PathVariable Integer id) {
		
		return bookRepo.findById(id);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookRepo.deleteById(id);
		return "Book: " + id + " deleted successfully";
		
	}
}
