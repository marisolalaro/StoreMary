package com.mari.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @ManyToOne
  @JoinColumn(name = "category_id")
  private Categories category;

  @Column(name = "name", length = 255, nullable = false)
  private String name;

  @Column(name = "description", length = 255)
  private String description;

  @Column(name = "stock", nullable = false)
  private int stock;

  @Column(name = "price", nullable = false)
  private double price;

  @Column(name = "active", nullable = false)
  private boolean active;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = Shape.STRING)
  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = Shape.STRING)
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "created_by", length = 255, nullable = false)
  private String createdBy;

  @Column(name = "updated_by", length = 255)
  private String updatedBy;


  public Products() {
  }
}
