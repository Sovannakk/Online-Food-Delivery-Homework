package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.*;
import com.kshrd.onlinefooddelivery.model.enums.OrderStatus;
import com.kshrd.onlinefooddelivery.model.request.OrderItemRequest;
import com.kshrd.onlinefooddelivery.model.request.OrderRequest;
import com.kshrd.onlinefooddelivery.repository.*;
import com.kshrd.onlinefooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).orElse(null);
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(orderRequest.getDeliveryPersonId()).orElse(null);
        Order order = orderRepository.save(orderRequest.toEntity(customer, null, deliveryPerson));
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest orderItemRequest : orderRequest.getOrderItemRequests()){
            MenuItem menuItem = menuItemRepository.findById(orderItemRequest.getMenuItemId()).orElse(null);
            OrderItem orderItem = orderItemRepository.save(orderItemRequest.toEntity(order, menuItem));
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public Order updateOrder(Long id, OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).orElse(null);
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(orderRequest.getDeliveryPersonId()).orElse(null);
        Order order = orderRepository.save(orderRequest.toEntity(id, customer, null, deliveryPerson));
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest orderItemRequest : orderRequest.getOrderItemRequests()){
            MenuItem menuItem = menuItemRepository.findById(orderItemRequest.getMenuItemId()).orElse(null);
            OrderItem orderItem = orderItemRepository.save(orderItemRequest.toEntity(id, order, menuItem));
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findAllByStatus(status);
    }
}
