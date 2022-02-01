package com.carrental.carrentalapp.models.rentals;

import com.carrental.carrentalapp.models.customer.Customer;
import com.carrental.carrentalapp.models.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
public class RentalStatus {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIncludeProperties({"name", "email", "gender"})
    private Customer customer;
    private String status;
    private String rentalData;

    public RentalStatus() {
    }

    public RentalStatus(Customer customer, String status, String rentalData) {
        this.customer = customer;
        this.status = status;
        this.rentalData = rentalData;
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
