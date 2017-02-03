package com.theironyard.services;

import com.theironyard.entities.Customer;
import com.theironyard.entities.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ben on 2/3/17.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {

    List<Purchase> findByCustomer (Customer category);
    List<Purchase> findByCategory (String category);
}
