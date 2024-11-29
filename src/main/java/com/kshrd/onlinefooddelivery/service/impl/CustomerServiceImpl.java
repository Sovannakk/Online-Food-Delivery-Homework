package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.request.CustomerRequest;
import com.kshrd.onlinefooddelivery.repository.CustomerRepository;
import com.kshrd.onlinefooddelivery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
