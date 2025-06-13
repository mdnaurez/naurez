package com.example.naurez.controller;

import com.example.naurez.dto.BookDTO;
import com.example.naurez.model.Book;
import com.example.naurez.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
   // private final BookService bookService;

    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    /*@PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }*/
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.save(bookDTO));
    }

    @PostMapping("/{bookId}/rate")
    public ResponseEntity<String> updateRating(@PathVariable int bookId) {
        bookService.updateBookRating(bookId);
        return ResponseEntity.ok("Rating updated");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

