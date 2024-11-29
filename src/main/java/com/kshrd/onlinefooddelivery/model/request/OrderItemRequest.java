package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.Order;
import com.kshrd.onlinefooddelivery.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private BigDecimal price;
    private Integer quantity;
    private Long menuItemId;

    public OrderItem toEntity(Order order, MenuItem menuItem) {
        return new OrderItem(null, price, quantity, order, menuItem);
    }

    public OrderItem toEntity(Long id, Order order, MenuItem menuItem) {
        return new OrderItem(id, price, quantity, order, menuItem);
    }
}
