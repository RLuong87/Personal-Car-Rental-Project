package com.hookedfishing.repositories;

import com.hookedfishing.models.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
