package com.mari.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stores")
public class Stores {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "address", length = 150, nullable = false)
  private String address;

  @Column(name = "city", length = 150, nullable = false)
  private String city;

  @Column(name = "opening_hours", length = 50, nullable = false)
  private String openingHours;


  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = Shape.STRING)
  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = Shape.STRING)
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @Column(name = "created_by", length = 255, nullable = false)
  private String createdBy;

  @Column(name = "updated_by", length = 255, nullable = false)
  private String updatedBy;
}
