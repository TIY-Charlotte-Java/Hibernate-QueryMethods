package com.theironyard;

import javax.persistence.*;

/**
 * Created by kelseynewman on 1/19/17.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    Customer customer;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    int ccv;

    @Column(nullable = false)
    String category;

    public Purchase() {
    }

    public Purchase(String date, String creditCard, int ccv, String category) {
        this.date = date;
        this.creditCard = creditCard;
        this.ccv = ccv;
        this.category = category;
    }

    public Purchase(Customer customer, String date, String creditCard, int ccv, String category) {
        this.date = date;
        this.creditCard = creditCard;
        this.ccv = ccv;
        this.category = category;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
