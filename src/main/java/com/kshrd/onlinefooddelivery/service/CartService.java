package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Cart;
import com.kshrd.onlinefooddelivery.model.CartItem;
import com.kshrd.onlinefooddelivery.model.request.CartItemRequest;

public interface CartService {
    Cart getCart(Long customerId);

    CartItem addItemToCart(Long customerId, CartItemRequest cartItemRequest);

    CartItem updateItemInCart(Long customerId, CartItemRequest cartItemRequest);

    void removeItemFromCart(Long customerId, Long menuItemId);
}
