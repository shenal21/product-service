package com.example.productservice.Repository;

import com.example.productservice.model.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByName(String name);
}
