package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {


}
