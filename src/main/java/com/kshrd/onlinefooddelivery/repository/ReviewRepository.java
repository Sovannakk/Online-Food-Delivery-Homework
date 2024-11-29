package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByRating(Integer rating);

    List<Review> findAllByRestaurantId(Long restaurantId);
}
