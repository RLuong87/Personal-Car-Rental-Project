package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.rentals.RentalStatus;
import com.carrental.carrentalapp.repositories.RentalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @PutMapping("/{id}")
    public @ResponseBody RentalStatus updateStatus(@PathVariable Long id, @RequestBody RentalStatus updates) {
        RentalStatus status = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getStatus() != null) status.setStatus(updates.getStatus());
        if (updates.getRentalData() != null) status.setRentalData(updates.getRentalData());

        return repository.save(status);
    }

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
