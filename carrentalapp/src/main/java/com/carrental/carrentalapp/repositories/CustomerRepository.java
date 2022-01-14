package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
