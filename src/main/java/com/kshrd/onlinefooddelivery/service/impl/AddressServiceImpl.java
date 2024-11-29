package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.Address;
import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.request.AddressRequest;
import com.kshrd.onlinefooddelivery.repository.AddressRepository;
import com.kshrd.onlinefooddelivery.repository.CustomerRepository;
import com.kshrd.onlinefooddelivery.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(AddressRequest addressRequest) {
        Customer customer = customerRepository.findById(addressRequest.getCustomerId()).orElse(null);
        return addressRepository.save(addressRequest.toEntity(customer));
    }

    @Override
    public Address updateAddress(Long id, AddressRequest addressRequest) {
        Customer customer = customerRepository.findById(addressRequest.getCustomerId()).orElse(null);
        return addressRepository.save(addressRequest.toEntity(id, customer));
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
