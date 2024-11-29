package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.request.MenuItemRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.MenuItemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/menuItems")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Operation(
            summary = "Get all menu items",
            description = "Retrieve a list of all menu items available in the system."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<MenuItem>>> getAllMenuItems() {
        ApiResponse<List<MenuItem>> response = ApiResponse.<List<MenuItem>>builder()
                .message("Get all menu items successfully")
                .status(HttpStatus.OK)
                .payload(menuItemService.getAllMenuItems())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get a menu item by ID",
            description = "Retrieve the details of a specific menu item using its unique ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItem>> getMenuItem(@PathVariable Long id) {
        ApiResponse<MenuItem> response = ApiResponse.<MenuItem>builder()
                .message("Get menu item successfully")
                .status(HttpStatus.OK)
                .payload(menuItemService.getMenuItem(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create a new menu item",
            description = "Add a new menu item to the system by providing necessary details like name, price, and description."
    )
    @PostMapping
    public ResponseEntity<ApiResponse<MenuItem>> createMenuItem(@RequestBody MenuItemRequest menuItemRequest) {
        ApiResponse<MenuItem> response = ApiResponse.<MenuItem>builder()
                .message("Create menu item successfully")
                .status(HttpStatus.CREATED)
                .payload(menuItemService.createMenuItem(menuItemRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Update an existing menu item",
            description = "Update the details of an existing menu item by providing its ID and the updated details."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItem>> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemRequest menuItemRequest) {
        ApiResponse<MenuItem> response = ApiResponse.<MenuItem>builder()
                .message("Update menu item successfully")
                .status(HttpStatus.OK)
                .payload(menuItemService.updateMenuItem(id, menuItemRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete a menu item by ID",
            description = "Delete a specific menu item from the system using its unique ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItem>> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        ApiResponse<MenuItem> response = ApiResponse.<MenuItem>builder()
                .message("Delete menu item successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Search menu items by name or category",
            description = "This endpoint allows you to search for menu items by their name or category. If both are provided, it will filter based on both criteria."
    )
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<MenuItem>>> searchMenuItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String categoryName) {

        List<MenuItem> menuItems = menuItemService.searchMenuItems(name, categoryName);
        ApiResponse<List<MenuItem>> response = ApiResponse.<List<MenuItem>>builder()
                .message("Search menu items successfully")
                .status(HttpStatus.OK)
                .payload(menuItems)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
