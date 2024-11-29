package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomer(Long id);

    Customer createCustomer(CustomerRequest customerRequest);

    Customer updateCustomer(Long id, CustomerRequest customerRequest);

    void deleteCustomer(Long id);
}
