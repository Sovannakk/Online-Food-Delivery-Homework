package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.request.MenuItemRequest;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();

    MenuItem getMenuItem(Long id);

    MenuItem createMenuItem(MenuItemRequest menuItemRequest);

    MenuItem updateMenuItem(Long id, MenuItemRequest menuItemRequest);

    void deleteMenuItem(Long id);

    List<MenuItem> searchMenuItems(String name, String categoryName);
}
