package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.DeliveryPerson;
import com.kshrd.onlinefooddelivery.model.request.DeliveryPersonRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.DeliveryPersonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/deliveryPersons")
@RequiredArgsConstructor
public class DeliveryPersonController {

    private final DeliveryPersonService deliveryPersonService;

    @Operation(
            summary = "Get all delivery persons",
            description = "Retrieve a list of all delivery persons registered in the system."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<DeliveryPerson>>> getAllDeliveryPersons() {
        ApiResponse<List<DeliveryPerson>> response = ApiResponse.<List<DeliveryPerson>>builder()
                .message("Get all delivery persons successfully")
                .status(HttpStatus.OK)
                .payload(deliveryPersonService.getAllDeliveryPersons())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get a delivery person by ID",
            description = "Retrieve the details of a specific delivery person using their unique ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryPerson>> getDeliveryPerson(@PathVariable Long id) {
        ApiResponse<DeliveryPerson> response = ApiResponse.<DeliveryPerson>builder()
                .message("Get delivery person successfully")
                .status(HttpStatus.OK)
                .payload(deliveryPersonService.getDeliveryPerson(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create a new delivery person",
            description = "Add a new delivery person to the system by providing the necessary details."
    )
    @PostMapping
    public ResponseEntity<ApiResponse<DeliveryPerson>> createDeliveryPerson(@RequestBody DeliveryPersonRequest deliveryPersonRequest) {
        ApiResponse<DeliveryPerson> response = ApiResponse.<DeliveryPerson>builder()
                .message("Create delivery person successfully")
                .status(HttpStatus.CREATED)
                .payload(deliveryPersonService.createDeliveryPerson(deliveryPersonRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Update an existing delivery person",
            description = "Update the details of an existing delivery person using their ID and the updated data."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryPerson>> updateDeliveryPerson(@PathVariable Long id, @RequestBody DeliveryPersonRequest deliveryPersonRequest) {
        ApiResponse<DeliveryPerson> response = ApiResponse.<DeliveryPerson>builder()
                .message("Update delivery person successfully")
                .status(HttpStatus.OK)
                .payload(deliveryPersonService.updateDeliveryPerson(id, deliveryPersonRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete a delivery person",
            description = "Remove a delivery person from the system by their unique ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<DeliveryPerson>> deleteDeliveryPerson(@PathVariable Long id) {
        deliveryPersonService.deleteDeliveryPerson(id);
        ApiResponse<DeliveryPerson> response = ApiResponse.<DeliveryPerson>builder()
                .message("Delete delivery person successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
