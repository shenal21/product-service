package com.example.productservice.Controller;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.Service.ProductService;
import com.example.productservice.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        String status = productService.createProduct(productDTO);
        return new ResponseEntity<>(status, status.equals("success") ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        String status = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(status, status.equals("success") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        String status = productService.deleteProduct(id);
        return new ResponseEntity<>(status, status.equals("success") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String categoryName) {
        List<Product> products = productService.getProductsByCategory(categoryName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/premium")
    public ResponseEntity<List<Product>> getPremiumProducts() {
        List<Product> products = productService.getPremiumProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

