package com.example.productservice.Service;

import com.example.productservice.DTO.CategoryDTO;
import com.example.productservice.Repository.ProductCategoryRepository;
import com.example.productservice.Model.ProductCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public String addNewCategory(CategoryDTO categoryDTO){
        ProductCategory category = productCategoryRepository.findByName(categoryDTO.getName());
        if (category != null) {
            return "validation_failure: Category already exists";
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(categoryDTO.getName());
        productCategory.setDescription(categoryDTO.getDescription());
        productCategoryRepository.save(productCategory);
        return "success";
    }
}
