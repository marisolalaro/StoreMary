package com.mari.store.controller;
import com.mari.store.entity.Categories;
import com.mari.store.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories") // Ruta base para la API
public class CategoriesController {

  @Autowired
  private CategoriesService categoriesService;


  @PostMapping
  public ResponseEntity<Categories> createCategory(@RequestBody Categories category) {
    Categories newCategory = categoriesService.saveCategory(category);
    return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
    Optional<Categories> category = categoriesService.getCategoryById(id);
    return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @GetMapping
  public ResponseEntity<Iterable<Categories>> getAllCategories() {
    Iterable<Categories> categories = categoriesService.getAllCategories();
    return new ResponseEntity<>(categories, HttpStatus.OK);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Categories> updateCategory(@PathVariable int id, @RequestBody Categories categoryDetails) {
    try {
      Categories updatedCategory = categoriesService.updateCategory(id, categoryDetails);
      return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
    try {
      categoriesService.deleteCategory(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
