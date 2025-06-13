package com.example.naurez.service;

import com.example.naurez.dto.OrderItemDTO;
import com.example.naurez.model.*;
import com.example.naurez.repository.BookRepository;
import com.example.naurez.repository.CustomerRepository;
import com.example.naurez.repository.OrderRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CustomerRepository customerRepository;



//    @Transactional
//    public OrderEntity placeOrder(OrderEntity order) {
//        for (OrderItem item : order.getItems()) {
//            Book book = bookRepository.findById(item.getBook().getId()).orElseThrow();
//            if (book.getStock() < item.getQuantity()) throw new RuntimeException("Insufficient stock");
//            book.setStock(book.getStock() - item.getQuantity());
//            item.setTotalPrice(book.getDiscountedPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
//            item.setOrder(order);
//        }
//        order.calculateTotal();
//        order.setOrderStatus(OrderStatus.PLACED);
//        return orderRepository.save(order);

@Transactional
public Order placeOrder(int customerId, List<OrderItemDTO> items) {
//    Customer customer = customerRepository.findById(customerId).orElseThrow();
//    Order order=new Order();
//    order.setCustomerId(customerId);
//    order.setCreatedAt(LocalDateTime.now());
//    order.setStatus(OrderStatus.PLACED);
//
//    BigDecimal total = BigDecimal.ZERO;
//    List<OrderItem> orderItems = new ArrayList<>();
//
//    for (OrderItemDTO dto : items) {
//        Book book = bookRepository.findById(dto.getBookId()).orElseThrow();
//        if (book.getStock() < dto.getQuantity()) throw new RuntimeException("Out of stock");
//        book.setStock(book.getStock() - dto.getQuantity());
//
//        BigDecimal base = book.getDiscountedPrice().multiply(BigDecimal.valueOf(dto.getQuantity()));
//        BigDecimal membershipDiscount = switch (customer.getMembershipLevel()) {
//            case PREMIUM -> base.multiply(BigDecimal.valueOf(0.05));
//            case GOLD -> base.multiply(BigDecimal.valueOf(0.10));
//            default -> BigDecimal.ZERO;
//        };
//        BigDecimal finalPrice = base.subtract(membershipDiscount);
//        total = total.add(finalPrice);
//
//        OrderItem item = new OrderItem();
//        item.setBookId(dto.getBookId());
//        item.setQuantity(dto.getQuantity());
//        item.setDiscount(membershipDiscount);
//        item.setOrder(order);
//        orderItems.add(item);
//    }
//
//    order.setItems(orderItems);
//    order.setShippingFee(BigDecimal.valueOf(40));
//    order.setTotalPrice(total.add(order.getShippingFee()));
//
//    Order saved = orderRepository.save(order);
////    emailService.sendOrderConfirmationAsync(customer.getEmail(), saved.getId());
//    return saved;

    Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    Order order = new Order();
    order.setCustomerId(customerId);
    order.setCreatedAt(LocalDateTime.now());
    order.setStatus(OrderStatus.PLACED);

    BigDecimal total = BigDecimal.ZERO;
    List<OrderItem> orderItems = new ArrayList<>();

    for (OrderItemDTO dto : items) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found: " + dto.getBookId()));

        if (book.getStock() < dto.getQuantity()) {
            throw new RuntimeException("Out of stock for book: " + book.getTitle());
        }

        book.setStock(book.getStock() - dto.getQuantity());

        // ✅ Safely get discountedPrice or fall back to normal price
        BigDecimal discountedPrice = book.getDiscountedPrice() != null
                ? book.getDiscountedPrice()
                : book.getPrice();

        BigDecimal base = discountedPrice.multiply(BigDecimal.valueOf(dto.getQuantity()));

        BigDecimal membershipDiscount = switch (customer.getMembershipLevel()) {
            case PREMIUM -> base.multiply(BigDecimal.valueOf(0.05));
            case GOLD -> base.multiply(BigDecimal.valueOf(0.10));
            default -> BigDecimal.ZERO;
        };

        BigDecimal finalPrice = base.subtract(membershipDiscount);
        total = total.add(finalPrice);

        OrderItem item = new OrderItem();
        item.setBookId(dto.getBookId());
        item.setQuantity(dto.getQuantity());
        item.setDiscount(membershipDiscount);
        item.setOrder(order);
        orderItems.add(item);
    }

    order.setItems(orderItems);
    order.setShippingFee(BigDecimal.valueOf(40));
    order.setTotalPrice(total.add(order.getShippingFee()));

    Order saved = orderRepository.save(order);

    // Optional: send confirmation email
    // emailService.sendOrderConfirmationAsync(customer.getEmail(), saved.getId());

    return saved;
}

}
