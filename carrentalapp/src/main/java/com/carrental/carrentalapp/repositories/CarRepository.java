package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Vehicle, Long> {


}
