package com.example.naurez.controller;

import com.example.naurez.dto.OrderItemDTO;
import com.example.naurez.model.Order;
import com.example.naurez.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(
            @RequestParam int customerId,
            @RequestBody List<OrderItemDTO> items) {
        return ResponseEntity.ok(orderService.placeOrder(customerId, items));
    }



//    @PostMapping
//    public ResponseEntity<Order> place(@RequestBody Order order) {
//        return ResponseEntity.ok(orderService.placeOrder(order));
//    }
}