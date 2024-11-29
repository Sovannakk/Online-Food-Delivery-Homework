package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.Order;
import com.kshrd.onlinefooddelivery.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatus(OrderStatus status);
}
