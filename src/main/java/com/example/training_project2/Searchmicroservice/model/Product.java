package com.example.training_project2.Searchmicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "products", type = "products", shards = 1)
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productCategory;
    private List<Variant> variants;
    private String description;

    public Product(String productId, String productName, String productCategory, List<Variant> variants) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.variants = variants;
    }


    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}