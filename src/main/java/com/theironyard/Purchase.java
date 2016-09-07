package com.theironyard;

import javax.persistence.*;

/**
 * Created by mfahrner on 9/7/16.
 */
@Entity
@Table(name = "items")
public class Purchase {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditcard;

    @Column(nullable = false)
    Integer cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {

    }

    public Purchase(String date, String creditcard, Integer cvv, String category, Customer customer) {
        this.date = date;
        this.creditcard = creditcard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }
}
