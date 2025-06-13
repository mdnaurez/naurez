package com.example.naurez.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int rating;
    private String comment;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("reviews")
    private Book book;

    @ManyToOne
    @JoinColumn
    private Customer customer;



}