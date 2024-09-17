package com.mari.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Categories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", length = 255, nullable = false)
  private String name;

  @Column(name = "description", length = 255)
  private String description;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "created_by", length = 255, nullable = false)
  private String createdBy;

  @Column(name = "updated_by", length = 255)
  private String updatedBy;

  @OneToMany(mappedBy = "category")
  @JsonIgnore
  private List<Products> products;

  public Categories() {
  }

}
