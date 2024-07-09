package com.example.productservice.Repository;

import com.example.productservice.Model.Product;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Cacheable("productsByCategory")
    List<Product> findByProductCategoryName(String categoryName, Pageable pageable);

    @Cacheable("premiumProducts")
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
}
