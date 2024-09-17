package com.mari.store.controller;

import com.mari.store.entity.Orders;
import com.mari.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

  @Autowired
  private OrdersService ordersService;


  @PostMapping
  public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
    Orders savedOrder = ordersService.saveOrder(order);
    return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Orders> getOrderById(@PathVariable Integer id) {
    Optional<Orders> order = ordersService.getOrderById(id);
    return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }


  @GetMapping
  public ResponseEntity<Iterable<Orders>> getAllOrders() {
    Iterable<Orders> orders = ordersService.getAllOrders();
    return ResponseEntity.ok(orders);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Orders> updateOrder(@PathVariable Integer id, @RequestBody Orders order) {
    Optional<Orders> existingOrder = ordersService.getOrderById(id);
    if (existingOrder.isPresent()) {
      order.setId(id);
      Orders updatedOrder = ordersService.saveOrder(order);
      return ResponseEntity.ok(updatedOrder);
    } else {
      return ResponseEntity.notFound().build();
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
    Optional<Orders> existingOrder = ordersService.getOrderById(id);
    if (existingOrder.isPresent()) {
      ordersService.deleteOrder(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
