package com.example.products_management.service;

import com.example.products_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    boolean saveProduct(Product product);

    Product findProductById(Integer id);

    boolean deleteProductById(Integer id);

    boolean edit(Product product);

    List<Product> searchProductByName(String name);
}
