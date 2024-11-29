package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.Cart;
import com.kshrd.onlinefooddelivery.model.CartItem;
import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.request.CartItemRequest;
import com.kshrd.onlinefooddelivery.repository.CartItemRepository;
import com.kshrd.onlinefooddelivery.repository.CartRepository;
import com.kshrd.onlinefooddelivery.repository.CustomerRepository;
import com.kshrd.onlinefooddelivery.repository.MenuItemRepository;
import com.kshrd.onlinefooddelivery.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MenuItemRepository menuItemRepository;
    private final CustomerRepository customerRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long customerId) {
        Cart cart = cartRepository.findById(customerId).orElse(null);
        if (cart == null) {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            Cart newCart = new Cart(null, customer, List.of());
            return cartRepository.save(newCart);
        }
        return cart;
    }

    @Override
    public CartItem addItemToCart(Long customerId, CartItemRequest cartItemRequest) {
        Cart cart = getCart(customerId);
        MenuItem menuItem = menuItemRepository.findById(cartItemRequest.getMenuItemId()).orElse(null);
        return cartItemRepository.save(cartItemRequest.toEntity(menuItem, cart));
    }

    @Override
    public CartItem updateItemInCart(Long customerId, CartItemRequest cartItemRequest) {
        Cart cart = getCart(customerId);
        MenuItem menuItem = menuItemRepository.findById(cartItemRequest.getMenuItemId()).orElse(null);
        CartItem cartItem = cartItemRepository.findByCartAndMenuItem(cart, menuItem);
        cartItem.setQuantity(cartItemRequest.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void removeItemFromCart(Long customerId, Long menuItemId) {
        Cart cart = getCart(customerId);
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElse(null);
        CartItem cartItem = cartItemRepository.findByCartAndMenuItem(cart, menuItem);
        cartItemRepository.delete(cartItem);
    }
}
