package com.example.productservice.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
//Adding indexes on fields used in GET APIs to improve performance.
@Table(indexes = {
    @Index(name = "idx_product_category_id", columnList = "product_category_id"),
    @Index(name = "idx_product_price", columnList = "price"),
    @Index(name = "idx_product_status", columnList = "status")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @Positive
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductComment> productComments;

    @NotBlank
    private String status;

    @Temporal(TemporalType.DATE)
    private Date launchDate;
}
