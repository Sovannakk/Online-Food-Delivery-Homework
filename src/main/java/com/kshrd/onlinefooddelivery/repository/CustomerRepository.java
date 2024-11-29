package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
