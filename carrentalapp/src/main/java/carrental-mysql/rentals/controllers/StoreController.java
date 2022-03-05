package com.hookedfishing.rentals.controllers;

import com.hookedfishing.rentals.models.store.Store;
import com.hookedfishing.rentals.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    //TODO: create stores to add customers and vehicles

    @Autowired
    private StoreRepository repository;

    @GetMapping
    public ResponseEntity<List<Store>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
//

}
