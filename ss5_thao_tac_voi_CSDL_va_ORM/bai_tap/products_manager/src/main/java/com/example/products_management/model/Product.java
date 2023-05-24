package com.example.products_management.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@Check(constraints = "price>0")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;
    @Column(name = "name_product", columnDefinition = "VARCHAR(50)", nullable = true)
    private String name;
    @Column(name = "price",nullable = false)
    private Integer price;
    private String description;
    private String producer;

    public Product(Integer id, String name, Integer price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Product(Integer price, String description, String producer) {
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
