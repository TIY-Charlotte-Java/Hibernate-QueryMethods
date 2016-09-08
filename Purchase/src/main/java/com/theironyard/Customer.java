package com.theironyard;

import javax.persistence.*;

//users class is an entity, stored in users table
@Entity
@Table(name = "customers")
public class Customer {
    @Id //id is the primary key, it is a generated value.  db is in control.
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true) // unique constraint, can't have two users with the same name.  this is a key constraint
            String name;

    @Column(nullable = false, unique = true) // unique constraint, can't have two users with the same name.  this is a key constraint
            String email;

    public Customer() {

    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s,  %s", this.name, this.email
        );

    }

}