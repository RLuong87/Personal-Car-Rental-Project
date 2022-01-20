package com.carrental.carrentalapp.models;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    private String color;
//    @ManyToMany
//    @JoinTable(
//            name = "customer_cars",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id")
//    )
//    private Set<Customer> customers;

    public Vehicle() {
    }

//    public Car(String make, String model, Integer year, String color, Set<Customer> customers) {
//        this.make = make;
//        this.model = model;
//        this.year = year;
//        this.color = color;
//        this.customers = customers;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
