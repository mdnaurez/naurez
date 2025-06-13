package com.example.naurez.dto;

import com.example.naurez.model.Review;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO
{
    public Long id;
    public int rating;
    public String comment;
    public int customerId;
    public int bookId;

    public Review to(){
        return Review.builder()
                .rating(this.rating)
                .build();
    }

}
