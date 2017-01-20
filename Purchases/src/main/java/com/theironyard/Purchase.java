package com.theironyard;

import javax.persistence.*;

/**
 * Created by graceconnelly on 1/19/17.
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
    String credit_card;

    @Column(nullable = false)
    String cvv;

    @Column(nullable = false)
    String category;

    public Purchase() {
    }

    public Purchase(Customer customer, String date, String credit_card, String cvv, String category) {
        this.customer = customer;
        this.date = date;
        this.credit_card = credit_card;
        this.cvv = cvv;
        this.category = category;
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

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}