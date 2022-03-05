package com.hookedfishing.rentals.repositories;

import com.hookedfishing.rentals.models.store.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {


}
