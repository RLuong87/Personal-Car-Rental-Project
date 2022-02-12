package com.hookedfishing.repositories;

import com.hookedfishing.models.customer.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByGender(String gender, Sort sort);

//    @Query("SELECT * FROM customer WHERE gender = ?1 and ?2 in vehicles")
//    Customer findByGenderAndVehicles(Sort sort, String gender, String vehicles);
}
