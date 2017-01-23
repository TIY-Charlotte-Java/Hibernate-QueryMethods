package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by stephenwilliamson on 1/22/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findById (int id);
}
