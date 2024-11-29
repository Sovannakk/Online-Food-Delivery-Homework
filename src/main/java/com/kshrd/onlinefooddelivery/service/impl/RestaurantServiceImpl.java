package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.Review;
import com.kshrd.onlinefooddelivery.model.request.RestaurantRequest;
import com.kshrd.onlinefooddelivery.repository.RestaurantRepository;
import com.kshrd.onlinefooddelivery.repository.ReviewRepository;
import com.kshrd.onlinefooddelivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant createRestaurant(RestaurantRequest restaurantRequest) {
        return restaurantRepository.save(restaurantRequest.toEntity());
    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantRequest restaurantRequest) {
        return restaurantRepository.save(restaurantRequest.toEntity(id));
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByRating(Integer rating) {
        List<Review> reviews = reviewRepository.findAllByRating(rating);
        Set<Restaurant> restaurants = new HashSet<>();
        for (Review review : reviews) {
            restaurants.add(review.getRestaurant());
        }
        return restaurants.stream().toList();
    }
}
