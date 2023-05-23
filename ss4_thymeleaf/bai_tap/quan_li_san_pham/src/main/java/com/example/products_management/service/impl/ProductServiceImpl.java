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
        List<Product>productList=productRepository.getAllProduct();
        return productList;
    }

    @Override
    public boolean saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public Product findProductById(Integer id) {
        List<Product>productList=productRepository.getAllProduct();
        for (Product product:productList) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }

    @Override
    public boolean edit(Product product) {
        List<Product>productList=productRepository.getAllProduct();
        for (Product product1:productList) {
            if (product1.getId()==product.getId()){
                productRepository.deleteProductById(product1.getId());
                productRepository.saveProduct(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product>productList=new ArrayList<>();
        List<Product>productList1=productRepository.getAllProduct();
        for (Product product1:productList1) {
            if (product1.getName().equalsIgnoreCase(name)){
                productList.add(product1);
            }
        }
        return productList;
    }
}
