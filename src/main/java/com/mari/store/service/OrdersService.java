package com.mari.store.service;

import com.mari.store.entity.Orders;
import com.mari.store.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService {

  @Autowired
  private OrdersRepository ordersRepository;


  public Orders saveOrder(Orders order) {
    return ordersRepository.save(order);
  }


  public Optional<Orders> getOrderById(Integer id) {
    return ordersRepository.findById(id);
  }


  public Iterable<Orders> getAllOrders() {
    return ordersRepository.findAll();
  }


  public void deleteOrder(Integer id) {
    ordersRepository.deleteById(id);
  }
}
