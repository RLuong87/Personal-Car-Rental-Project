package com.carrental.carrentalapp.models.store;

import com.carrental.carrentalapp.models.customer.Customer;
import com.carrental.carrentalapp.models.vehicle.Vehicle;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;

    //TODO: Test the relationship between store and customers
    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<Customer> customers;

    public Store() {
    }

    public Store(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
