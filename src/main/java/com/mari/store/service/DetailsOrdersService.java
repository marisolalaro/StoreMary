package com.mari.store.service;

import com.mari.store.entity.DetailsOrders;
import com.mari.store.repository.DetailsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailsOrdersService {

  @Autowired
  private DetailsOrdersRepository detailsOrdersRepository;


  public DetailsOrders saveDetailsOrder(DetailsOrders detailsOrder) {
    return detailsOrdersRepository.save(detailsOrder);
  }


  public Optional<DetailsOrders> getDetailsOrderById(Integer id) {
    return detailsOrdersRepository.findById(id);
  }

  public Iterable<DetailsOrders> getAllDetailsOrders() {
    return detailsOrdersRepository.findAll();
  }


  public DetailsOrders updateDetailsOrder(Integer id, DetailsOrders detailsOrder) {
    if (detailsOrdersRepository.existsById(id)) {
      detailsOrder.setId(id);
      return detailsOrdersRepository.save(detailsOrder);
    } else {
      throw new RuntimeException("DetailsOrder not found with ID: " + id);
    }
  }

  public void deleteDetailsOrder(Integer id) {
    if (detailsOrdersRepository.existsById(id)) {
      detailsOrdersRepository.deleteById(id);
    } else {
      throw new RuntimeException("DetailsOrder not found with ID: " + id);
    }
  }
}
