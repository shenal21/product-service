package com.example.productservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}