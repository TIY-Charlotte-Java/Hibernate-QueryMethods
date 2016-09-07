package com.theironyard;

import javax.persistence.*;

/**
 * Created by mfahrner on 9/7/16.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false)
    String email;

    public Customer() {

    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s ", this.name, this.email);
    }
}
