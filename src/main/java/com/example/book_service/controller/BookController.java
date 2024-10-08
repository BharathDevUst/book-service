package com.example.book_service.controller;

import com.example.book_service.dao.BookRepository;
import com.example.book_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookRepository bookRepo;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @PostMapping
    public Book addBook(Book newBook) {
        return bookRepo.saveAndFlush(newBook);
    }

    @PostMapping("/{id}")
    public Book getABook(@PathVariable("id") long id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.orElse(null);
    }
}
