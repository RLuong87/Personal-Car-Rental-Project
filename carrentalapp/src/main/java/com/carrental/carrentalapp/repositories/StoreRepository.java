package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Customer, Long> {

}
