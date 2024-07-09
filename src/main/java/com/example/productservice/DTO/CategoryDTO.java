package com.example.productservice.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank
    private String name;

    private String description;
}
