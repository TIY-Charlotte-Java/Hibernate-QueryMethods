package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by charlesrath on 9/7/16.
 */
public interface CustomersRepository extends JpaRepository<Customer, Integer> {
}
