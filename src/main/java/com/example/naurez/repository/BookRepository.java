package com.example.naurez.repository;

import com.example.naurez.dto.BookDTO;
import com.example.naurez.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT new com.example.naurez.dto.BookDTO(b.id, b.title, b.author, b.genre, b.price, b.stock, b.rating, b.publisher, b.discountedPrice) FROM Book b ORDER BY b.rating DESC")
    List<BookDTO> findTopSellingBooksThisMonth();

}
