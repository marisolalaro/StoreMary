package com.mari.store.controller;

import com.mari.store.entity.Stores;
import com.mari.store.service.StoresService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/api/stores")
public class StoresController {

  @Autowired
  private StoresService storesService;


  @GetMapping
  public ResponseEntity<List<Stores>> getAllStores() {
    List<Stores> stores = storesService.getAllStores();
    return new ResponseEntity<>(stores, HttpStatus.OK);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Stores> getStoreById(@PathVariable Integer id) {
    Optional<Stores> store = storesService.getStoreById(id);
    if (store.isPresent()) {
      return new ResponseEntity<>(store.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping
  public ResponseEntity<Stores> createStore(@RequestBody Stores store) {
    Stores createdStore = storesService.createStore(store);
    return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Stores> updateStore(@PathVariable Integer id, @RequestBody Stores storeDetails) {
    try {
      Stores updatedStore = storesService.updateStore(id, storeDetails);
      return new ResponseEntity<>(updatedStore, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStore(@PathVariable Integer id) {
    try {
      storesService.deleteStore(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
