package com.mari.store.repository;

import com.mari.store.entity.Stores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoresRepository extends CrudRepository<Stores, Integer> {

}
