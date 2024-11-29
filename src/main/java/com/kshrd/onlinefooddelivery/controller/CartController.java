package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Cart;
import com.kshrd.onlinefooddelivery.model.CartItem;
import com.kshrd.onlinefooddelivery.model.request.CartItemRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @Operation(
            summary = "Retrieve a customer's cart",
            description = "Fetch the cart associated with a specific customer by their ID."
    )
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ApiResponse<Cart>> getCart(@PathVariable Long customerId) {
        ApiResponse<Cart> response = ApiResponse.<Cart>builder()
                .message("Get cart successfully")
                .status(HttpStatus.OK)
                .payload(cartService.getCart(customerId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Add an item to the cart",
            description = "Add a menu item to the customer's cart by providing the customer ID and the item details."
    )
    @PostMapping("/customer/{customerId}/addItem")
    public ResponseEntity<ApiResponse<CartItem>> addItemToCart(@PathVariable Long customerId, @RequestBody CartItemRequest cartItemRequest) {
        ApiResponse<CartItem> response = ApiResponse.<CartItem>builder()
                .message("Add item to cart successfully")
                .status(HttpStatus.CREATED)
                .payload(cartService.addItemToCart(customerId, cartItemRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Update the quantity of an item in the cart",
            description = "Update the quantity of an existing menu item in the customer's cart."
    )
    @PutMapping("/customer/{customerId}/updateItem")
    public ResponseEntity<ApiResponse<CartItem>> updateItemInCart(@PathVariable Long customerId, @RequestBody CartItemRequest cartItemRequest) {
        ApiResponse<CartItem> response = ApiResponse.<CartItem>builder()
                .message("Update item quantity in cart successfully")
                .status(HttpStatus.OK)
                .payload(cartService.updateItemInCart(customerId, cartItemRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Remove an item from the cart",
            description = "Remove a specific menu item from the customer's cart by providing the customer ID and menu item ID."
    )
    @DeleteMapping("/customer/{customerId}/menuItem/{menuItemId}/removeItem")
    public ResponseEntity<ApiResponse<Void>> removeItemFromCart(@PathVariable Long customerId, @PathVariable Long menuItemId) {
        cartService.removeItemFromCart(customerId, menuItemId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Remove item from cart successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
