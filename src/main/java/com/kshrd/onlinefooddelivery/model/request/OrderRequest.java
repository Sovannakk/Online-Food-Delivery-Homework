package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import com.kshrd.onlinefooddelivery.model.Order;
import com.kshrd.onlinefooddelivery.model.OrderItem;
import com.kshrd.onlinefooddelivery.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private LocalDate orderDate;
    private OrderStatus status;
    private Long customerId;
    private List<OrderItemRequest> orderItemRequests;
    private Long deliveryPersonId;

    public Order toEntity(Customer customer, List<OrderItem> orderItems, DeliveryPerson deliveryPerson) {
        return new Order(null, orderDate, status, customer, orderItems, deliveryPerson);
    }

    public Order toEntity(Long id, Customer customer, List<OrderItem> orderItems, DeliveryPerson deliveryPerson) {
        return new Order(id, orderDate, status, customer, orderItems, deliveryPerson);
    }

}
