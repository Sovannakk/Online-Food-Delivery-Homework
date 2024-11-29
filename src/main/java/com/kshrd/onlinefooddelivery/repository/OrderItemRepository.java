package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
