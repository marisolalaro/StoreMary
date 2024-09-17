package com.mari.store.service;

import com.mari.store.entity.Categories;
import com.mari.store.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoriesService {

  @Autowired
  private CategoriesRepository categoriesRepository;


  public Categories saveCategory(Categories category) {
    return categoriesRepository.save(category);
  }


  public Optional<Categories> getCategoryById(int id) {
    return categoriesRepository.findById(id);
  }

  public Iterable<Categories> getAllCategories() {
    return categoriesRepository.findAll();
  }

  public Categories updateCategory(int id, Categories categoryDetails) {
    return categoriesRepository.findById(id).map(category -> {
      category.setName(categoryDetails.getName());
      category.setDescription(categoryDetails.getDescription());
      category.setUpdatedAt(categoryDetails.getUpdatedAt());
      category.setUpdatedBy(categoryDetails.getUpdatedBy());
      return categoriesRepository.save(category);
    }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
  }

  public void deleteCategory(int id) {
    categoriesRepository.deleteById(id);
  }
}
