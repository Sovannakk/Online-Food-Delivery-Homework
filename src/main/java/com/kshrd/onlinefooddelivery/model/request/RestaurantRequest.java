package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    private String name;
    private String address;
    private String contact;

    public Restaurant toEntity() {
        return new Restaurant(null, name, address, contact, List.of(), List.of());
    }

    public Restaurant toEntity(Long id) {
        return new Restaurant(id, name, address, contact, List.of(), List.of());
    }
}

