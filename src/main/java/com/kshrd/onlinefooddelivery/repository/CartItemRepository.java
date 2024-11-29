package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.Cart;
import com.kshrd.onlinefooddelivery.model.CartItem;
import com.kshrd.onlinefooddelivery.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartAndMenuItem(Cart cart, MenuItem menuItem);
}
