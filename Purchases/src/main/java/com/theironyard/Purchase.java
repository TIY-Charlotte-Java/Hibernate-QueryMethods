package com.theironyard;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by charlesrath on 9/7/16.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column
    Date date;

    @Column
    String creditCard;

    @Column
    String cvv;

    @Column
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {}

    public Purchase(Date date, String creditCard, String cvv, String category, Customer customer) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }
}
