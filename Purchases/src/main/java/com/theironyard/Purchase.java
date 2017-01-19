package com.theironyard;

import javax.persistence.*;

/**
 * Created by emileenmarianayagam on 1/19/17.
 */

@Entity
@Table (name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String credit_card;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne // many different purchases can go to one customer
    Customer customer;


    public Purchase() {
    }

    public Purchase(String date, String credit_card, int cvv, String category) {
        this.date = date;
        this.credit_card = credit_card;
        this.cvv = cvv;
        this.category = category;
    }

    public Purchase(String date, String credit_card, int cvv, String category, Customer customer) {
        this.date = date;
        this.credit_card = credit_card;
        this.cvv = cvv;
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

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}





