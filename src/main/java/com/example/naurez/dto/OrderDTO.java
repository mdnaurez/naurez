package com.example.naurez.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    public Integer id;
    public UUID customerId;
    public List<OrderItemDTO> items;
    public BigDecimal shippingFee;
    public BigDecimal totalPrice;
    public String orderStatus;
    public LocalDate createdAt;
}
