package com.carrental.carrentalapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String dob;
    private String phoneNumber;
    private String[] vehicles;
    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<RentalStatus> rentals;

    public Customer() {

    }

    public Customer(String name, String email, String gender, String dob, String phoneNumber, String[] vehicles) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.vehicles = vehicles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(String[] vehicles) {
        this.vehicles = vehicles;
    }
}
