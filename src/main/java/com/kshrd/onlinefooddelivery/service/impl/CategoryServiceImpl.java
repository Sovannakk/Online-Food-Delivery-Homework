package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.Category;
import com.kshrd.onlinefooddelivery.model.request.CategoryRequest;
import com.kshrd.onlinefooddelivery.repository.CategoryRepository;
import com.kshrd.onlinefooddelivery.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.save(categoryRequest.toEntity());
    }

    @Override
    public Category updateCategory(Long id, CategoryRequest categoryRequest) {
        return categoryRepository.save(categoryRequest.toEntity(id));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
