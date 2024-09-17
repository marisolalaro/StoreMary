package com.mari.store.controller;

import com.mari.store.entity.DetailsOrders;
import com.mari.store.service.DetailsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/details-orders")
public class DetailsOrdersController {

  @Autowired
  private DetailsOrdersService detailsOrdersService;


  @PostMapping
  public ResponseEntity<DetailsOrders> createDetailsOrder(@RequestBody DetailsOrders detailsOrder) {
    DetailsOrders createdDetailsOrder = detailsOrdersService.saveDetailsOrder(detailsOrder);
    return new ResponseEntity<>(createdDetailsOrder, HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
  public ResponseEntity<DetailsOrders> getDetailsOrderById(@PathVariable Integer id) {
    Optional<DetailsOrders> detailsOrder = detailsOrdersService.getDetailsOrderById(id);
    return detailsOrder.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping
  public ResponseEntity<Iterable<DetailsOrders>> getAllDetailsOrders() {
    Iterable<DetailsOrders> detailsOrders = detailsOrdersService.getAllDetailsOrders();
    return ResponseEntity.ok(detailsOrders);
  }


  @PutMapping("/{id}")
  public ResponseEntity<DetailsOrders> updateDetailsOrder(@PathVariable Integer id,
      @RequestBody DetailsOrders detailsOrder) {
    try {
      DetailsOrders updatedDetailsOrder = detailsOrdersService.updateDetailsOrder(id, detailsOrder);
      return ResponseEntity.ok(updatedDetailsOrder);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDetailsOrder(@PathVariable Integer id) {
    try {
      detailsOrdersService.deleteDetailsOrder(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
