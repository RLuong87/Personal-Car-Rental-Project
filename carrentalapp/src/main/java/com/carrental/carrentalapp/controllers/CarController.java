package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.Vehicle;
import com.carrental.carrentalapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Vehicle> getAllCars() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getCarById(@PathVariable Long id) {
       Optional<Vehicle> car = repository.findById(id);

       if (car.isEmpty()) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(car.get(), HttpStatus.OK);
    }

    @PostMapping
    public Vehicle createCar(@RequestBody Vehicle newCar) {
        return repository.save(newCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
