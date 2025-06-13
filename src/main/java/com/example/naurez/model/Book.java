package com.example.naurez.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String genre;
    private BigDecimal price;
    private int stock;
    private double rating;
    private String publisher;
    private BigDecimal discountedPrice;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<Review> reviews = new ArrayList<>();

    public void updateAverageRating() {
        if (!reviews.isEmpty()) {
            this.rating = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        }
    }
}
