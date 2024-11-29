package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String name;
    private String email;

    public Customer toEntity() {
        return new Customer(null, name, email, List.of(), List.of());
    }

    public Customer toEntity(Long id) {
        return new Customer(id, name, email, List.of(), List.of());
    }
}
