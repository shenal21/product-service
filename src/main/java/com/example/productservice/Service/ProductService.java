package com.example.productservice.Service;

import com.example.productservice.DTO.ProductDTO;
import com.example.productservice.Repository.ProductCategoryRepository;
import com.example.productservice.Repository.ProductCommentRepository;
import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.model.Product;
import com.example.productservice.model.ProductCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    public String createProduct(ProductDTO productDTO) {
        ProductCategory category = productCategoryRepository.findByName(productDTO.getCategory());
        if (category == null) {
            return "validation_failure: Category doesn't exist";
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductCategory(category);
        product.setStatus("A");
        product.setLaunchDate(new Date());

        productRepository.save(product);
        return "success";
    }

    public String updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            return "validation_failure: Product with Id: "+ productId +" doesn't exist";
        }

        Product product = optionalProduct.get();
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if (productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if (productDTO.getPrice() != null) {
            product.setPrice(productDTO.getPrice());
        }
        productRepository.save(product);
        return "success";
    }

    public String deleteProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            return "validation_failure: Product with Id: " + productId + " doesn't exist";
        }

        Product product = optionalProduct.get();
        product.setStatus("D");

        productRepository.save(product);
        return "success";
    }

    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByProductCategoryName(categoryName);
    }

    public List<Product> getPremiumProducts() {
        return productRepository.findByPriceGreaterThanEqual(new BigDecimal(500));
    }
}
