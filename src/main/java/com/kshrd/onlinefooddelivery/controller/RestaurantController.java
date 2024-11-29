package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.request.RestaurantRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Operation(summary = "Get all restaurants", description = "Retrieve a list of all restaurants.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Restaurant>>> getAllRestaurants() {
        ApiResponse<List<Restaurant>> response = ApiResponse.<List<Restaurant>>builder()
                .message("Get all restaurants successfully")
                .status(HttpStatus.OK)
                .payload(restaurantService.getAllRestaurants())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get restaurant by ID", description = "Retrieve a specific restaurant by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Restaurant>> getRestaurant(@PathVariable Long id) {
        ApiResponse<Restaurant> response = ApiResponse.<Restaurant>builder()
                .message("Get restaurant successfully")
                .status(HttpStatus.OK)
                .payload(restaurantService.getRestaurant(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new restaurant", description = "Create a new restaurant in the system.")
    @PostMapping
    public ResponseEntity<ApiResponse<Restaurant>> createRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        ApiResponse<Restaurant> response = ApiResponse.<Restaurant>builder()
                .message("Create restaurant successfully")
                .status(HttpStatus.CREATED)
                .payload(restaurantService.createRestaurant(restaurantRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update restaurant by ID", description = "Update an existing restaurant by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Restaurant>> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequest restaurantRequest) {
        ApiResponse<Restaurant> response = ApiResponse.<Restaurant>builder()
                .message("Update restaurant successfully")
                .status(HttpStatus.OK)
                .payload(restaurantService.updateRestaurant(id, restaurantRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete restaurant by ID", description = "Delete a specific restaurant by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Restaurant>> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        ApiResponse<Restaurant> response = ApiResponse.<Restaurant>builder()
                .message("Delete restaurant successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get restaurants by rating",
            description = "This endpoint retrieves a list of restaurants filtered by the given rating. You can specify a rating to get restaurants that match or exceed that rating."
    )
    @GetMapping("/rating")
    public ResponseEntity<ApiResponse<List<Restaurant>>> getRestaurantsByRating(@RequestParam Integer rating) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByRating(rating);
        ApiResponse<List<Restaurant>> response = ApiResponse.<List<Restaurant>>builder()
                .message("Get restaurants by rating successfully")
                .status(HttpStatus.OK)
                .payload(restaurants)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
