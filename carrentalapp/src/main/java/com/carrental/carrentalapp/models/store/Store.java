package com.carrental.carrentalapp.models.store;

import com.carrental.carrentalapp.models.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String longitude;
    private String latitude;
    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<Customer> customers;

    public Store() {
    }

    public Store(String address, String city, String longitude, String latitude, List<Customer> customers) {
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.customers = customers;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
