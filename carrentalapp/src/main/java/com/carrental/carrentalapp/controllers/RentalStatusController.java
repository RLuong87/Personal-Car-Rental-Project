package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.rentals.RentalStatus;
import com.carrental.carrentalapp.repositories.RentalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/status")
public class RentalStatusController {

    @Autowired
    private RentalStatusRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<RentalStatus>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalStatus> createOne(@RequestBody RentalStatus status) {
        System.out.println(status.getCustomer().getId());

        return new ResponseEntity<>(repository.save(status), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<RentalStatus> updateOne(@RequestBody RentalStatus status) {
//        similar to customer update
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/customer/{cId}")
    public ResponseEntity<List<RentalStatus>> getByCustomerId(@PathVariable Long cId) {
        return new ResponseEntity<>(repository.findAllByCustomer_id(cId), HttpStatus.OK);
    }
}
