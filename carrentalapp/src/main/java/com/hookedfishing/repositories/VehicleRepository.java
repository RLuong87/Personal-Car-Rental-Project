package com.hookedfishing.repositories;

import com.hookedfishing.models.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
