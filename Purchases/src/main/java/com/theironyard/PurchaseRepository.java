package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by emileenmarianayagam on 1/19/17.
 *
 */

//taking in the purchase object and passing in the ID
public interface PurchaseRepository extends CrudRepository <Purchase, Integer> {
}
