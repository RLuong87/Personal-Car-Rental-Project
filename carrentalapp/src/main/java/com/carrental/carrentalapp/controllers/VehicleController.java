package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.vehicle.Vehicle;
import com.carrental.carrentalapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    /*
    Routes to build
    Get information for all cars (Customers will only see cars available)
     */

    @Autowired
    private VehicleRepository repository;

    @GetMapping
    public List<Vehicle> getAllCars() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
       Optional<Vehicle> vehicle = repository.findById(id);

       if (vehicle.isEmpty()) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
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
