package com.example.naurez.service;

import com.example.naurez.dto.ReviewDTO;
import com.example.naurez.model.Book;
import com.example.naurez.model.Customer;
import com.example.naurez.model.Review;
import com.example.naurez.repository.BookRepository;
import com.example.naurez.repository.CustomerRepository;
import com.example.naurez.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Autowired
    private CustomerRepository customerRepository;

    public Review submitReview(Review review, int bookId, int customerId) {
//        review.setBook(bookRepository.findById(bookId).orElseThrow());
//        review.setCustomer(customerRepository.findById(customerId).orElseThrow());
//        Review saved = reviewRepository.save(review);
//        review.getBook().updateAverageRating();
//        bookRepository.save(review.getBook());
       // return saved;
//
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));

        review.setBook(book);
        review.setCustomer(customer);

        Review saved = reviewRepository.save(review);

        book.updateAverageRating(); // this should call reviewRepository.getAvgRating internally
        bookRepository.save(book);

        return saved;
    }

}
