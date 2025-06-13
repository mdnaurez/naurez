package com.example.naurez.repository;

import com.example.naurez.dto.CustomerDTO;
import com.example.naurez.model.Customer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query("SELECT new com.example.naurez.dto.CustomerDTO(c.id, c.name, c.email, c.membershipLevel, c.registrationDate) FROM Customer c ORDER BY c.registrationDate DESC")
//    List<CustomerDTO> findTopCustomers(Pageable pageable);


//    default List<CustomerDTO> findTopCustomers(int limit) {
//        return findTopCustomers(PageRequest.of(0, limit));
//    }
}
