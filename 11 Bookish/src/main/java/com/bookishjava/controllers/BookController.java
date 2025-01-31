package com.bookishjava.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.bookishjava.models.database.Book;
import com.bookishjava.repositories.BookRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {
    
    private final BookRepository repository;

    BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping("books/{id}")
    Optional<Book> getBookById(@PathVariable Long id)
    {
        return repository.findById(id);
    }

    @GetMapping("books/author/{author}")
    List<Book> getBookByAuthor(@PathVariable String author)
    {
        return repository.findByAuthor(author);

    }

    @PostMapping("/books")
    void insertBook(@RequestBody Book book)
    {
        repository.save(book);
    }
}
