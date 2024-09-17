package com.mari.store.service;

import com.mari.store.entity.Products;
import com.mari.store.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

  @Autowired
  private ProductsRepository productsRepository;

  public Products saveProduct(Products product) {
    return productsRepository.save(product);
  }

  public Optional<Products> getProductById(int id) {
    return productsRepository.findById(id);
  }

  public Iterable<Products> getAllProducts() {
    return productsRepository.findAll();
  }

  public Products updateProduct(int id, Products productDetails) {
    return productsRepository.findById(id).map(product -> {
      product.setName(productDetails.getName());
      product.setDescription(productDetails.getDescription());
      product.setStock(productDetails.getStock());
      product.setPrice(productDetails.getPrice());
      product.setActive(productDetails.isActive());
      product.setUpdatedAt(productDetails.getUpdatedAt());
      product.setUpdatedBy(productDetails.getUpdatedBy());
      return productsRepository.save(product);
    }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
  }

  public void deleteProduct(int id) {
    productsRepository.deleteById(id);
  }
}
