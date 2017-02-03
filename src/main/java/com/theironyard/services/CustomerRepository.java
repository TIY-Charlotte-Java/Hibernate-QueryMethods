package com.theironyard.services;

import com.theironyard.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 2/3/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Override
    Customer findOne(Integer integer);
}
