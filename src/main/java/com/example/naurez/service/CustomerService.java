package com.example.naurez.service;

import com.example.naurez.dto.CustomerDTO;
import com.example.naurez.model.Customer;
import com.example.naurez.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
    public Customer save(CustomerDTO customerDTO){
        Customer customer=customerDTO.to();
        return customerRepository.save(customer);
    }

    public Customer getById(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }
}

