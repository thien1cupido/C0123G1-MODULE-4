package com.example.products_management.repository;

import com.example.products_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    boolean saveProduct(Product product);

    boolean deleteProductById(Integer id);

}
