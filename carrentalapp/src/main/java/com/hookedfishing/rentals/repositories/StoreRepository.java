package com.hookedfishing.rentals.repositories;

import com.hookedfishing.rentals.models.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
