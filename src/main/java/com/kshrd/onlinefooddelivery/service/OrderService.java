package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Order;
import com.kshrd.onlinefooddelivery.model.enums.OrderStatus;
import com.kshrd.onlinefooddelivery.model.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrder(Long id);

    Order createOrder(OrderRequest orderRequest);

    Order updateOrder(Long id, OrderRequest orderRequest);

    void deleteOrder(Long id);

    List<Order> getOrdersByStatus(OrderStatus status);
}
