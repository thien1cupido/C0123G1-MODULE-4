package com.example.products_management.repository.impl;

import com.example.products_management.model.Product;
import com.example.products_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone 4", 400, "Hàng cũ", "Apple"));
        productList.add(new Product(2, "Iphone 5", 500, "Hàng cũ", "Apple"));
        productList.add(new Product(3, "Iphone 6", 600, "Hàng cũ", "Apple"));
        productList.add(new Product(4, "Samsung J5", 600, "Hàng cũ", "Samsung"));
        productList.add(new Product(5, "Oppo Neo 9", 600, "Hàng cũ", "Oppo"));
        productList.add(new Product(6, "Iphone 14", 2000, "Hàng mới", "Apple"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public boolean saveProduct(Product product) {
        return productList.add(product);
    }


    @Override
    public boolean deleteProductById(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }
}
