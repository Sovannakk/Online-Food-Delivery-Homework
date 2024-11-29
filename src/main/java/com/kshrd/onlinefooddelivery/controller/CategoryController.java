package com.kshrd.onlinefooddelivery.controller;

import com.kshrd.onlinefooddelivery.model.Category;
import com.kshrd.onlinefooddelivery.model.request.CategoryRequest;
import com.kshrd.onlinefooddelivery.model.response.ApiResponse;
import com.kshrd.onlinefooddelivery.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            summary = "Get all categories",
            description = "Retrieve a list of all categories available in the system."
    )
    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        ApiResponse<List<Category>> response = ApiResponse.<List<Category>>builder()
                .message("Get all categories successfully")
                .status(HttpStatus.OK)
                .payload(categoryService.getAllCategories())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Get a category by ID",
            description = "Retrieve a specific category's details by its unique ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> getCategory(@PathVariable Long id) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Get category successfully")
                .status(HttpStatus.OK)
                .payload(categoryService.getCategory(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create a new category",
            description = "Add a new category to the system by providing the category details."
    )
    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Create category successfully")
                .status(HttpStatus.CREATED)
                .payload(categoryService.createCategory(categoryRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Update an existing category",
            description = "Update the details of an existing category using its unique ID and the updated data."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Update category successfully")
                .status(HttpStatus.OK)
                .payload(categoryService.updateCategory(id, categoryRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete a category",
            description = "Remove a category from the system by its unique ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        ApiResponse<Category> response = ApiResponse.<Category>builder()
                .message("Delete category successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
