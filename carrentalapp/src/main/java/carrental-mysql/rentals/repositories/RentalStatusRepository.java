package com.hookedfishing.rentals.repositories;

import com.hookedfishing.rentals.models.rentals.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalStatusRepository extends JpaRepository<RentalStatus, Long> {

    List<RentalStatus> findAllByCustomer_id(Long id);
}
