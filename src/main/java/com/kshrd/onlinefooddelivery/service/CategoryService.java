package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Category;
import com.kshrd.onlinefooddelivery.model.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategory(Long id);

    Category createCategory(CategoryRequest categoryRequest);

    Category updateCategory(Long id, CategoryRequest categoryRequest);

    void deleteCategory(Long id);
}
