package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by mfahrner on 9/7/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
