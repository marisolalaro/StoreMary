package com.mari.store.repository;

import com.mari.store.entity.DetailsOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsOrdersRepository extends CrudRepository<DetailsOrders, Integer> {

}