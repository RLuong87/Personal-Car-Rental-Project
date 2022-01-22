package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
