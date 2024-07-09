package com.example.productservice.Repository;

import com.example.productservice.Model.ProductComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
}
