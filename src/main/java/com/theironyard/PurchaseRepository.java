package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by stephenwilliamson on 1/22/17.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    List<Purchase> findByCustomer (Customer category);
    List<Purchase> findByCategory(String category);
}