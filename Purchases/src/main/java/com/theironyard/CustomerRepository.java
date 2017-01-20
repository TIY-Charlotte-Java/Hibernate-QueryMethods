package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kelseynewman on 1/19/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findById(int id);

}
