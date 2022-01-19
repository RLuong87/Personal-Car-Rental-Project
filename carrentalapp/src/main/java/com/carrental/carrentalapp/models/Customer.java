package com.carrental.carrentalapp.models;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String role;
    private String gender;
    private String dob;
    private String phoneNumber;
    private String[] vehicles;
//    @OneToMany
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private List<Geekout> geekouts;
//    @ManyToMany
//    @JoinTable(
//            name = "customer_cars",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "car_id")
//    )
//    private Set<Car> cars;

    public Customer() {

    }

//    public Customer(String name, String email, String role, String dob, String phoneNumber, Set<Car> cars) {
//        this.name = name;
//        this.email = email;
//        this.role = role;
//        this.dob = dob;
//        this.phoneNumber = phoneNumber;
//        this.cars = cars;
//    }


    public Customer(String name, String email, String role, String gender, String dob, String phoneNumber, String[] vehicles) {
        this.name = name;
        this.email = email;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }


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
