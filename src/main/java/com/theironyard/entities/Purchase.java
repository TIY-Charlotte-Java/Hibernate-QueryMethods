package com.theironyard.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ben on 2/3/17.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    Customer customer;

    @Column (nullable = false)
    String date;

    @Column (nullable = false)
    String creditCard;

    @Column (nullable = false)
    int cvv;

    @Column (nullable = false)
    String category;

    public Purchase() {
    }

    public Purchase(Customer customer, String date, String creditCard, int cvv, String category) {
        this.customer = customer;
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
