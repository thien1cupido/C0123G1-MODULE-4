package com.example.shopping_cart.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public ShoppingCart() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }
    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }
}
