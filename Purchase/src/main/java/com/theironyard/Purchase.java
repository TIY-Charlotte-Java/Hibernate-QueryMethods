package com.theironyard;

import javax.persistence.*;

        import javax.persistence.*;

//users class is an entity, stored in users table
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id //id is the primary key, it is a generated value.  db is in control.
    @GeneratedValue
    int id;

//    @Column(nullable = false)
//    int customerId;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {

    }

    public Purchase(String date, String creditCard, int cvv, String category, Customer customer) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }



    }
