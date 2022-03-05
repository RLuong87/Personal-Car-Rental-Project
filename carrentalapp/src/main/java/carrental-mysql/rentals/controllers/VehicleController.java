package com.hookedfishing.rentals.controllers;

import com.hookedfishing.rentals.models.vehicle.Vehicle;
import com.hookedfishing.rentals.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {


    //TODO: Routes to build --> Get information for all cars (Customers will only see cars available)


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

    @PutMapping("/{id}")
    public @ResponseBody
    Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updates) {
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) vehicle.setName(updates.getName());
        if (updates.getYear() != null) vehicle.setYear(updates.getYear());
        if (updates.getColor() != null) vehicle.setColor(updates.getColor());

        return repository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
