package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    //crud repo takes in 2 types, first is thing you store (purchase) and second is the type you are using as your identity column.

    List<Purchase> findByCategory(String category);

}

// method findByCategory passes in a string category and gives me a list of purchases.