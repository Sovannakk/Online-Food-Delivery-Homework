package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Order;
import com.kshrd.onlinefooddelivery.model.enums.OrderStatus;
import com.kshrd.onlinefooddelivery.model.request.OrderRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        ApiResponse<List<Order>> response = ApiResponse.<List<Order>>builder()
                .message("Get all orders successfully")
                .status(HttpStatus.OK)
                .payload(orderService.getAllOrders())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrder(@PathVariable Long id) {
        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Get order successfully")
                .status(HttpStatus.OK)
                .payload(orderService.getOrder(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new order", description = "Create a new order in the system.")
    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody OrderRequest orderRequest) {
        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Create order successfully")
                .status(HttpStatus.CREATED)
                .payload(orderService.createOrder(orderRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update order by ID", description = "Update an existing order by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Update order successfully")
                .status(HttpStatus.OK)
                .payload(orderService.updateOrder(id, orderRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete order by ID", description = "Delete a specific order by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Delete order successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get orders by status",
            description = "This endpoint allows you to filter and retrieve orders by their current status (e.g., pending, completed, cancelled)."
    )
    @GetMapping("/status")
    public ResponseEntity<ApiResponse<List<Order>>> getOrdersByStatus(@RequestParam OrderStatus status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        ApiResponse<List<Order>> response = ApiResponse.<List<Order>>builder()
                .message("Get orders by status successfully")
                .status(HttpStatus.OK)
                .payload(orders)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
