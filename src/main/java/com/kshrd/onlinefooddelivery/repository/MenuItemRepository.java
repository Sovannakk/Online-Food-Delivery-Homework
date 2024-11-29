package com.kshrd.onlinefooddelivery.repository;

import com.kshrd.onlinefooddelivery.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAllByNameContainingOrCategory_NameContaining(String name, String categoryName);
}
