package com.theironyard;

import javax.persistence.*;
import java.util.List;

/**
 * Created by stephenwilliamson on 1/22/17.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "customer")
    List<Purchase> purchase;

    public Customer() {
    }

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }
}