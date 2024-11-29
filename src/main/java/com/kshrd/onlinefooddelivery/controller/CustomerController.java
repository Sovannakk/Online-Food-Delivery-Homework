package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Customer;
import com.kshrd.onlinefooddelivery.model.request.CustomerRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
            summary = "Get all customers",
            description = "Retrieve a list of all customers registered in the system."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers() {
        ApiResponse<List<Customer>> response = ApiResponse.<List<Customer>>builder()
                .message("Get all customers successfully")
                .status(HttpStatus.OK)
                .payload(customerService.getAllCustomers())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get a customer by ID",
            description = "Retrieve the details of a specific customer using their unique ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> getCustomer(@PathVariable Long id) {
        ApiResponse<Customer> response = ApiResponse.<Customer>builder()
                .message("Get customer successfully")
                .status(HttpStatus.OK)
                .payload(customerService.getCustomer(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create a new customer",
            description = "Add a new customer to the system by providing customer details."
    )
    @PostMapping
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody CustomerRequest customerRequest) {
        ApiResponse<Customer> response = ApiResponse.<Customer>builder()
                .message("Create customer successfully")
                .status(HttpStatus.CREATED)
                .payload(customerService.createCustomer(customerRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Update an existing customer",
            description = "Update the details of an existing customer using their ID and the updated customer data."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        ApiResponse<Customer> response = ApiResponse.<Customer>builder()
                .message("Update customer successfully")
                .status(HttpStatus.OK)
                .payload(customerService.updateCustomer(id, customerRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete a customer",
            description = "Remove a customer from the system by their unique ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        ApiResponse<Customer> response = ApiResponse.<Customer>builder()
                .message("Delete customer successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
