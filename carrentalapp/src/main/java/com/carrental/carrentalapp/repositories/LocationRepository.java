package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.store.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {


}
