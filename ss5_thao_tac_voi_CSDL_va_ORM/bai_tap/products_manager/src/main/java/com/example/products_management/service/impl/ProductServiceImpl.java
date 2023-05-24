package com.example.products_management.service.impl;

import com.example.products_management.model.Product;
import com.example.products_management.repository.IProductRepository;
import com.example.products_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public boolean saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }

    @Override
    public boolean editProduct(Product product) {
        return productRepository.editProduct(product);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList =productRepository.searchProductByName(name);
        return productList;
    }
}
