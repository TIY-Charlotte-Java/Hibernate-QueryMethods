package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by emileenmarianayagam on 1/19/17.
 */

// taking in the customer object and passing in the id
public interface CustomerRepository extends  CrudRepository<Customer, Integer>{
 Customer findById (int id);
}
