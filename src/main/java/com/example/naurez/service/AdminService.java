package com.example.naurez.service;

import com.example.naurez.dto.BookDTO;
import com.example.naurez.dto.CustomerDTO;
import com.example.naurez.repository.BookRepository;
import com.example.naurez.repository.CustomerRepository;
import com.example.naurez.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepo;
//
//    public List<CustomerDTO> getTopCustomers(int limit) {
//       return customerRepository.findTopCustomers(limit);
//    }

    public List<BookDTO> getBestsellersThisMonth() {
        return bookRepo.findTopSellingBooksThisMonth();
    }
}

