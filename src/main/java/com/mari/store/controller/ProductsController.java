package com.mari.store.controller;

import com.mari.store.entity.Products;
import com.mari.store.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

  @Autowired
  private ProductsService productsService;


  @PostMapping
  public ResponseEntity<Products> createProduct(@RequestBody Products product) {
    Products newProduct = productsService.saveProduct(product);
    return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Products> getProductById(@PathVariable int id) {
    Optional<Products> product = productsService.getProductById(id);
    return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @GetMapping
  public ResponseEntity<Iterable<Products>> getAllProducts() {
    Iterable<Products> products = productsService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Products> updateProduct(@PathVariable int id, @RequestBody Products productDetails) {
    try {
      Products updatedProduct = productsService.updateProduct(id, productDetails);
      return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
    try {
      productsService.deleteProduct(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
