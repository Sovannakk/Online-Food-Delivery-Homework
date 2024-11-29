package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurant(Long id);

    Restaurant createRestaurant(RestaurantRequest restaurantRequest);

    Restaurant updateRestaurant(Long id, RestaurantRequest restaurantRequest);

    void deleteRestaurant(Long id);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByRating(Integer rating);
}
