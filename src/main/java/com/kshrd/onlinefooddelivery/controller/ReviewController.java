package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Review;
import com.kshrd.onlinefooddelivery.model.request.ReviewRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "Get all reviews", description = "Retrieve a list of all reviews.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Review>>> getAllReviews() {
        ApiResponse<List<Review>> response = ApiResponse.<List<Review>>builder()
                .message("Get all reviews successfully")
                .status(HttpStatus.OK)
                .payload(reviewService.getAllReviews())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get review by ID", description = "Retrieve a specific review by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Review>> getReview(@PathVariable Long id) {
        ApiResponse<Review> response = ApiResponse.<Review>builder()
                .message("Get review successfully")
                .status(HttpStatus.OK)
                .payload(reviewService.getReviewById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new review", description = "Create a new review for a restaurant or dish.")
    @PostMapping
    public ResponseEntity<ApiResponse<Review>> createReview(@RequestBody ReviewRequest reviewRequest) {
        ApiResponse<Review> response = ApiResponse.<Review>builder()
                .message("Create review successfully")
                .status(HttpStatus.CREATED)
                .payload(reviewService.createReview(reviewRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update review by ID", description = "Update an existing review by its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Review>> updateReview(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        ApiResponse<Review> response = ApiResponse.<Review>builder()
                .message("Update review successfully")
                .status(HttpStatus.OK)
                .payload(reviewService.updateReview(id, reviewRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete review by ID", description = "Delete a specific review by its ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Review>> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        ApiResponse<Review> response = ApiResponse.<Review>builder()
                .message("Delete review successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get reviews for a specific restaurant",
            description = "This endpoint retrieves all reviews for a specific restaurant based on its ID. It helps customers read feedback from other users."
    )
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<ApiResponse<List<Review>>> getReviewsByRestaurant(@PathVariable Long restaurantId) {
        List<Review> reviews = reviewService.getReviewsByRestaurant(restaurantId);
        ApiResponse<List<Review>> response = ApiResponse.<List<Review>>builder()
                .message("Get reviews for restaurant successfully")
                .status(HttpStatus.OK)
                .payload(reviews)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
