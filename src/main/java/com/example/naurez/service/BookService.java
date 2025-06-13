package com.example.naurez.service;

import com.example.naurez.dto.BookDTO;
import com.example.naurez.model.Book;
import com.example.naurez.model.Review;
import com.example.naurez.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

   /* public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book save(BookDTO bookDTO) {
        Book book=bookDTO.to();
        return bookRepository.save(book);
    }
    public void updateBookRating(int bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.updateAverageRating();
        bookRepository.save(book);
    }

}
