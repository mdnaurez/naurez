package com.example.naurez.dto;

import com.example.naurez.model.Book;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    public Integer id;
    public String title;
    public String author;
    public String genre;
    public BigDecimal price;
    public int stock;
    public double rating;
    public String publisher;
    public BigDecimal discountedPrice;

    public Book to(){
        return Book.builder()
                .author(this.author)
                .discountedPrice(this.discountedPrice)
                .genre(this.genre)
                .stock(this.stock)
                .rating(this.rating)
                .publisher(this.publisher)
                .price(this.price)
                .build();
    }
}
