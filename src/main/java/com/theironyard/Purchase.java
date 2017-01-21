package com.theironyard;

import javax.persistence.*;


@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Customer customer;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String creditcard;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    private String category;

    public Purchase() {
    }

    public Purchase(int id, Customer customer, String date, String creditcard, String cvv, String category) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.creditcard = creditcard;
        this.cvv = cvv;
        this.category = category;
    }

    public Purchase(String date, String creditcard, String cvv, String category) {
        this.date = date;
        this.creditcard = creditcard;
        this.cvv = cvv;
        this.category = category;
    }

    public Purchase(Customer customer, String date, String creditcard, String cvv, String category) {
        this.customer = customer;
        this.date = date;
        this.creditcard = creditcard;
        this.cvv = cvv;
        this.category = category;
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

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
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
