package com.example.naurez.controller;

import com.example.naurez.dto.BookDTO;
import com.example.naurez.dto.CustomerDTO;
import com.example.naurez.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

//    @GetMapping("/top-customers")
//    public ResponseEntity<List<CustomerDTO>> topCustomers(@RequestParam(defaultValue = "5") int limit) {
//        return ResponseEntity.ok(adminService.getTopCustomers(limit));
//    }

    @GetMapping("/bestsellers")
    public ResponseEntity<List<BookDTO>> bestsellers() {
        System.out.println("=== AdminController.getBestSellers called ===");
        return ResponseEntity.ok(adminService.getBestsellersThisMonth());
    }
}


