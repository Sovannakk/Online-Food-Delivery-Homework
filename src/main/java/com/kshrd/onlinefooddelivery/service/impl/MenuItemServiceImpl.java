package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.request.MenuItemRequest;
import com.kshrd.onlinefooddelivery.repository.MenuItemRepository;
import com.kshrd.onlinefooddelivery.repository.RestaurantRepository;
import com.kshrd.onlinefooddelivery.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItem(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem createMenuItem(MenuItemRequest menuItemRequest) {
        Restaurant restaurant = restaurantRepository.findById(menuItemRequest.getRestaurantId()).orElse(null);
        return menuItemRepository.save(menuItemRequest.toEntity(restaurant));
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItemRequest menuItemRequest) {
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> searchMenuItems(String name, String categoryName) {
        return menuItemRepository.findAllByNameContainingOrCategory_NameContaining(name, categoryName);
    }
}
