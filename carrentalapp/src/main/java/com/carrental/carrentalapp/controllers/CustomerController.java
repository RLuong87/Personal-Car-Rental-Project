package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.customer.Customer;
import com.carrental.carrentalapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody Customer getCustomer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Customer>> getCustomersByGender(@PathVariable String gender) {
        return new ResponseEntity<>(repository.findAllByGender(gender, Sort.by("name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(repository.save(newCustomer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) customer.setName(updates.getName());
        if (updates.getEmail() != null) customer.setEmail(updates.getEmail());
        if (updates.getDob() != null) customer.setDob(updates.getDob());
        if (updates.getGender() != null) customer.setGender(updates.getGender());
        if (updates.getPhoneNumber() != null) customer.setPhoneNumber(updates.getPhoneNumber());
        if (updates.vehicles != null) customer.vehicles = updates.vehicles;

        return repository.save(customer);
    }

    @PutMapping("/vehicle")
    public Customer addCar(@RequestBody Customer updates) {
        Customer customer = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        customer.vehicles.addAll(updates.vehicles);
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
