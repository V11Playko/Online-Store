package com.playko.store.domain.model;

import com.playko.store.domain.exception.DomainException;

import java.util.Date;

public class ProductModel {
    private Long id;
    private String name;
    private String description;
    private Double stock;
    private Double price;
    private String status;
    private Date createAt;
    private CategoryModel category;

    public ProductModel(Long id, String name, String description, Double stock, Double price, String status, Date createAt, CategoryModel category) {
        if (name.isEmpty()) throw new DomainException("Name cannot be blank");
        if (description.isEmpty()) throw new DomainException("Description cannot be blank");
        if (stock.toString().isEmpty()) throw new DomainException("Stock cannot be blank");
        if (price.toString().isEmpty()) throw new DomainException("Price cannot be blank");
        if (status.isEmpty()) throw new DomainException("Status cannot be blank");
        if (createAt.toString().isEmpty()) throw new DomainException("CreateAt cannot be blank");

        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.status = status;
        this.createAt = createAt;
        this.category = category;
    }

    public ProductModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) throw new DomainException("Name cannot be blank");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) throw new DomainException("Description cannot be blank");
        this.description = description;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        if (stock.toString().isEmpty()) throw new DomainException("Stock cannot be blank");
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price.toString().isEmpty()) throw new DomainException("Price cannot be blank");
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.isEmpty()) throw new DomainException("Status cannot be blank");
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        if (createAt.toString().isEmpty()) throw new DomainException("CreateAt cannot be blank");
        this.createAt = createAt;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
