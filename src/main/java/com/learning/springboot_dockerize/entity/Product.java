package com.learning.springboot_dockerize.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "PRODUCT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int productId;
    private String productName;
    private double productPrice;
}
