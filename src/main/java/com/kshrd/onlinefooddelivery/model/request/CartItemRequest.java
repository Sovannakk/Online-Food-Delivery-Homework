package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.Cart;
import com.kshrd.onlinefooddelivery.model.CartItem;
import com.kshrd.onlinefooddelivery.model.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
    private Long menuItemId;
    private Integer quantity;

    public CartItem toEntity(MenuItem menuItem, Cart cart) {
        return new CartItem(null, quantity, cart, menuItem);
    }

}
