package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.models.Customer;
import com.carrental.carrentalapp.repositories.CustomerRepository;
import com.carrental.carrentalapp.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private Map<Long, Customer> customers = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();
//    private final CustomerRepository repository;
//
//    public CustomerController(CustomerRepository repository) {
//        this.repository = repository;
//    }

    public CustomerController() {
        Long id = idCounter.incrementAndGet();
        customers.put(id, new Customer(id, "Rich Luong", "rich@test.com", "customer", "08/14/1987", "401-000-000"));
        id = idCounter.incrementAndGet();
        customers.put(id, new Customer(id, "Aly", "aly@testing.com", "customer", "02/22/2001", "401-000-000"));
    }


    @GetMapping
    public List<Customer> all() {
        return new ArrayList<Customer>(customers.values());
    }

    @GetMapping("/{id}") // Dynamic Route
    public Customer customer(@PathVariable Long id) {
        return customers.get(id);
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        Long id = idCounter.incrementAndGet();
        newCustomer.setId(id);
        customers.put(id, newCustomer);
        return newCustomer;
    }
}
