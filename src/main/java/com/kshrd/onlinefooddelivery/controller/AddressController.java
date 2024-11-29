package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Address;
import com.kshrd.onlinefooddelivery.model.request.AddressRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Retrieve all addresses", description = "Get a list of all saved addresses.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Address>>> getAllAddresses() {
        ApiResponse<List<Address>> response = ApiResponse.<List<Address>>builder()
                .message("Get all addresses successfully")
                .status(HttpStatus.OK)
                .payload(addressService.getAllAddresses())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Retrieve a specific address", description = "Get an address by its unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Address>> getAddress(@PathVariable Long id) {
        ApiResponse<Address> response = ApiResponse.<Address>builder()
                .message("Get address successfully")
                .status(HttpStatus.OK)
                .payload(addressService.getAddressById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new address", description = "Add a new address to the database.")
    @PostMapping
    public ResponseEntity<ApiResponse<Address>> createAddress(@RequestBody AddressRequest addressRequest) {
        ApiResponse<Address> response = ApiResponse.<Address>builder()
                .message("Create address successfully")
                .status(HttpStatus.CREATED)
                .payload(addressService.createAddress(addressRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update an address", description = "Modify an existing address by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Address>> updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest) {
        ApiResponse<Address> response = ApiResponse.<Address>builder()
                .message("Update address successfully")
                .status(HttpStatus.OK)
                .payload(addressService.updateAddress(id, addressRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete an address", description = "Remove an address from the database using its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Address>> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        ApiResponse<Address> response = ApiResponse.<Address>builder()
                .message("Delete address successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
