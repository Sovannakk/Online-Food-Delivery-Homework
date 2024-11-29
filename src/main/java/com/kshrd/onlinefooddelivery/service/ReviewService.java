package com.kshrd.onlinefooddelivery.service;

import com.kshrd.onlinefooddelivery.model.Review;
import com.kshrd.onlinefooddelivery.model.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(Long id);

    Review createReview(ReviewRequest reviewRequest);

    Review updateReview(Long id, ReviewRequest reviewRequest);

    void deleteReview(Long id);

    List<Review> getReviewsByRestaurant(Long restaurantId);
}
