package com.carrental.carrentalapp.models.vehicle;

import com.carrental.carrentalapp.models.customer.Customer;
import com.carrental.carrentalapp.models.rentals.RentalStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    private String color;
    @ManyToMany
    @JoinTable(
            name = "customer_vehicle",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    public Vehicle() {
    }

    public Vehicle(String name, Integer year, String color, Set<Customer> customers) {
        this.name = name;
        this.year = year;
        this.color = color;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;
//    }
}
