package com.carrental.carrentalapp.repositories;

import com.carrental.carrentalapp.models.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
