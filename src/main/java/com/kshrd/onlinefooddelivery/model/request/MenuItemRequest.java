package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Long restaurantId; // ID of the restaurant the menu item belongs to

    public MenuItem toEntity(Restaurant restaurant) {
        return new MenuItem(null, name, price, description, restaurant, null, List.of());
    }
}

