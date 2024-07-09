package com.example.productservice.Controller;

import com.example.productservice.DTO.CategoryDTO;
import com.example.productservice.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")

public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CategoryDTO category) {
        String status = categoryService.addNewCategory(category);
        return new ResponseEntity<>(status, status.equals("success") ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
