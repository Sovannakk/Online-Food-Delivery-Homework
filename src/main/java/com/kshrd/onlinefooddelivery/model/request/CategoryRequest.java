package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;

    public Category toEntity() {
        return new Category(null, name, List.of());
    }

    public Category toEntity(Long id) {
        return new Category(id, name, List.of());
    }
}
