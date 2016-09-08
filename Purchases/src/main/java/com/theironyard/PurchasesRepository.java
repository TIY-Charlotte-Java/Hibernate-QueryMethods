package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by charlesrath on 9/7/16.
 */

public interface PurchasesRepository extends JpaRepository<Purchase, Integer> {
    @Query("SELECT DISTINCT p.category FROM Purchase p")
    List<String> getAllCategories();

    @Query("SELECT p FROM Purchase p WHERE p.category LIKE ?1")
    List<Purchase> findByCategory(String category);
}
