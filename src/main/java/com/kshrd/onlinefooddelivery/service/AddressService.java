package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Address;
import com.kshrd.onlinefooddelivery.model.request.AddressRequest;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address createAddress(AddressRequest addressRequest);

    Address updateAddress(Long id, AddressRequest addressRequest);

    void deleteAddress(Long id);
}
