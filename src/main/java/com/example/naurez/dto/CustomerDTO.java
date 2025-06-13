package com.example.naurez.dto;

import com.example.naurez.model.Customer;
import com.example.naurez.model.MembershipLevel;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    public Integer id;
    public String name;
    public String email;
    public String membershipLevel;
    public LocalDate registrationDate;

    public Customer to(){
        return Customer.builder()
                .email(this.email)
                .name(this.name)
                .membershipLevel(MembershipLevel.valueOf(this.membershipLevel))
                .registrationDate(this.registrationDate)
                .build();
    }
}
