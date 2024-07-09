package com.example.productservice.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank
    private String name;

    private String description;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String category;
}