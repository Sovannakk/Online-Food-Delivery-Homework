package com.kshrd.onlinefooddelivery.model.request;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import com.kshrd.onlinefooddelivery.model.Restaurant;
import com.kshrd.onlinefooddelivery.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private int rating;
    private String comment;
    private Long restaurantId;
    private Long menuItemId;

    public Review toEntity(Restaurant restaurant, MenuItem menuItem) {
        return new Review(null, rating, comment, restaurant, menuItem);
    }

    public Review toEntity(Long id, Restaurant restaurant, MenuItem menuItem) {
        return new Review(id, rating, comment, restaurant, menuItem);
    }
}
