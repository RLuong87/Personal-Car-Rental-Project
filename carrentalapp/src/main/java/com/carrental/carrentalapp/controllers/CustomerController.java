package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.Car;
import com.carrental.carrentalapp.models.Customer;
import com.carrental.carrentalapp.repositories.CarRepository;
import com.carrental.carrentalapp.repositories.CustomerRepository;
import com.carrental.carrentalapp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final Map<Long, Customer> customers = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();
//    private final CustomerRepository repository;
//
//    public CustomerController(CustomerRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    private CustomerRepository repository;

//    public CustomerController() {
//        Long id = idCounter.incrementAndGet();
//        customers.put(id, new Customer("Rich Luong", "rich@test.com", "customer", "08/14/1987", "401-000-000"));
//        id = idCounter.incrementAndGet();
//        customers.put(id, new Customer("Aly", "aly@testing.com", "customer", "02/22/2001", "401-000-000"));
//    }


    @GetMapping
    public List<Customer> all() {
        return new ArrayList<Customer>(customers.values());
    }

    @GetMapping("/{id}") // Dynamic Route
    public Customer getCustomerById(@PathVariable Long id) {
        return customers.get(id);
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        Long id = idCounter.incrementAndGet();
        newCustomer.setId(id);
        customers.put(id, newCustomer);
        return newCustomer;
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) customer.setName(updates.getName());
        if (updates.getEmail() != null) customer.setEmail(updates.getEmail());
        if (updates.getDob() != null) customer.setDob(updates.getDob());
        if (updates.getRole() != null) customer.setRole(updates.getRole());
        if (updates.getPhoneNumber() != null) customer.setPhoneNumber(updates.getPhoneNumber());
        if (updates.getCars() != null) customer.setCars(updates.getCars());

        return repository.save(customer);
    }

    @PutMapping("/car")
    public Customer addCar(@RequestBody Customer updates) {
        Customer customer = repository.findById(updates.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        customer.getCars().addAll(updates.getCars());
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
