package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.Car;
import com.carrental.carrentalapp.models.Customer;
import com.carrental.carrentalapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarController {

    /*
    Routes to build
    Get information for all cars (Customers will only see cars available)

     */

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> getAllCars() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
       Optional<Car> car = repository.findById(id);

       if (car.isEmpty()) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(car.get(), HttpStatus.OK);
    }

    @PostMapping
    public Car createCar(@RequestBody Car newCar) {
        return repository.save(newCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
