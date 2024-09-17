package com.mari.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import com.mari.store.entity.Stores;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Stores store;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "date", nullable = false)
  private java.sql.Date date;

  @Column(name = "shipping_address", length = 255)
  private String shippingAddress;

  @Column(name = "is_delivery", nullable = false)
  private Boolean isDelivery;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @Column(name = "created_by", length = 255)
  private String createdBy;

  @Column(name = "updated_by", length = 255)
  private String updatedBy;


  public Orders() {

  }
}
