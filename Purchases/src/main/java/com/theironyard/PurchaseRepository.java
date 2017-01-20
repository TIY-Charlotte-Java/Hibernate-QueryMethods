package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emileenmarianayagam on 1/19/17.
 *
 */

//taking in the purchase object and passing in the ID
public interface PurchaseRepository extends CrudRepository <Purchase, Integer> {
    List<Purchase> findByCustomer (Customer category);
    List<Purchase> findByCategory(String category);
}
