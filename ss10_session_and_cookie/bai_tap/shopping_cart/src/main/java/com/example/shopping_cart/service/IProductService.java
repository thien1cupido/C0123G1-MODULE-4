package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAllProduct();

    Optional <Product> findProductById(Integer id);
}
