package com.example.naurez.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {
    public Long id;
    public int bookId;
    public int quantity;
    public BigDecimal discountApplied;
    public BigDecimal totalPrice;


}
