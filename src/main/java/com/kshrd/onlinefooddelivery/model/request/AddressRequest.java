package com.kshrd.onlinefooddelivery.model.request;
import com.kshrd.onlinefooddelivery.model.Address;
import com.kshrd.onlinefooddelivery.model.Customer;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Long customerId;

    public Address toEntity(Customer customer) {
        return new Address(null, street, city, state, postalCode, customer);
    }

    public Address toEntity(Long id, Customer customer) {
        return new Address(id, street, city, state, postalCode, customer);
    }
}

