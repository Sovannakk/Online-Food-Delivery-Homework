package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
}
