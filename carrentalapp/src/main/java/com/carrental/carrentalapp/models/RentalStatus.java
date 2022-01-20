package com.carrental.carrentalapp.models;

import javax.persistence.*;

@Entity
public class RentalStatus {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private String status;
    private String rentalData;

    public RentalStatus() {
    }

    public RentalStatus(Customer customer, String status, String content) {
        this.customer = customer;
        this.status = status;
        this.rentalData = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentalData() {
        return rentalData;
    }

    public void setRentalData(String rentalData) {
        this.rentalData = rentalData;
    }
}
