package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mfahrner on 9/7/16.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    List<Purchase> findByCategory(String category);
}
