package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by graceconnelly on 1/19/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    Customer findById(Integer id);
}
