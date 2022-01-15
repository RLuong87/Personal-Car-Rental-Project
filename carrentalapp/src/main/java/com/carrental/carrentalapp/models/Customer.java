package com.carrental.carrentalapp.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String email;
    private String role;
    private String dob;
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private List<Car> cars;
    @ManyToMany
    @JoinTable(
            name = "car_names",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Set<Car> cars;

    public Customer() {

    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email, String role, String dob, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return String.format("Customer(id=%s, name=%s, role=%s, email=%s, dob=%s, phoneNumber=%s)", id.toString(), name, email, role, dob, phoneNumber);
    }
}
