package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.rentals.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalStatusRepository extends JpaRepository<RentalStatus, Long> {

    List<RentalStatus> findAllByCustomer_id(Long id);
}
