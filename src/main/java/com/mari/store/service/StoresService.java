package com.mari.store.service;

import com.mari.store.entity.Stores;
import com.mari.store.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StoresService {

  @Autowired
  private StoresRepository storesRepository;

  public List<Stores> getAllStores() {
    return (List<Stores>) storesRepository.findAll();
  }

  public Optional<Stores> getStoreById(Integer id) {
    return storesRepository.findById(id);
  }

  public Stores createStore(Stores store) {
    return storesRepository.save(store);
  }

  public Stores updateStore(Integer id, Stores storeDetails) {
    return storesRepository.findById(id).map(store -> {
      store.setName(storeDetails.getName());
      store.setAddress(storeDetails.getAddress());
      store.setCity(storeDetails.getCity());
      store.setOpeningHours(storeDetails.getOpeningHours());
      store.setCreatedAt(storeDetails.getCreatedAt());
      store.setUpdatedAt(storeDetails.getUpdatedAt());
      store.setCreatedBy(storeDetails.getCreatedBy());
      store.setUpdatedBy(storeDetails.getUpdatedBy());
      return storesRepository.save(store);
    }).orElseThrow(() -> new RuntimeException("Store not found with id " + id));
  }

  public void deleteStore(Integer id) {
    storesRepository.deleteById(id);
  }
}
