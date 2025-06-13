package com.example.naurez.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bookId;
    private int quantity;
    private BigDecimal discount;

    @ManyToOne @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("items")
    private Order order;


}
