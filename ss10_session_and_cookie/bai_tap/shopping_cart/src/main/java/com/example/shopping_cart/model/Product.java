package com.example.shopping_cart.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_product",columnDefinition = "VARCHAR(100)")
    private String nameProduct;
    @Column(columnDefinition = "TEXT")
    private String img;
    private Long price;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public Product() {
    }

    public Product(Integer id, String nameProduct, String img, Long price, String description) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.img = img;
        this.price = price;
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
