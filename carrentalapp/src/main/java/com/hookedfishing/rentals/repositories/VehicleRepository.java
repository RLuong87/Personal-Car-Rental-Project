package com.hookedfishing.rentals.repositories;

import com.hookedfishing.rentals.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
