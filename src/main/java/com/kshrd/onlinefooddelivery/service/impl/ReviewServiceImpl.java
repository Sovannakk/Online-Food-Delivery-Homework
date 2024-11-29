package com.kshrd.onlinefooddelivery.service.impl;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.Review;
import com.kshrd.onlinefooddelivery.model.request.ReviewRequest;
import com.kshrd.onlinefooddelivery.repository.MenuItemRepository;
import com.kshrd.onlinefooddelivery.repository.RestaurantRepository;
import com.kshrd.onlinefooddelivery.repository.ReviewRepository;
import com.kshrd.onlinefooddelivery.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;


    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review createReview(ReviewRequest reviewRequest) {
        Restaurant restaurant = restaurantRepository.findById(reviewRequest.getRestaurantId()).orElse(null);
        MenuItem menuItem = menuItemRepository.findById(reviewRequest.getMenuItemId()).orElse(null);
        return reviewRepository.save(reviewRequest.toEntity(restaurant, menuItem));
    }

    @Override
    public Review updateReview(Long id, ReviewRequest reviewRequest) {
        Restaurant restaurant = restaurantRepository.findById(reviewRequest.getRestaurantId()).orElse(null);
        MenuItem menuItem = menuItemRepository.findById(reviewRequest.getMenuItemId()).orElse(null);
        return reviewRepository.save(reviewRequest.toEntity(id, restaurant, menuItem));
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getReviewsByRestaurant(Long restaurantId) {
        return reviewRepository.findAllByRestaurantId(restaurantId);
    }
}
