package com.example.shopping_cart.service.impl;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private boolean checkItemInCart(Product product, ShoppingCart shoppingCart) {
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProductMap().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product, ShoppingCart shoppingCart) {
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProductMap().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product, ShoppingCart shoppingCart) {
        if (!checkItemInCart(product, shoppingCart)) {
            shoppingCart.getProductMap().put(product, 1);
        } else {
            Map.Entry<Product, Integer> entry = selectItemInCart(product, shoppingCart);
            Integer newQuantity = entry.getValue() + 1;
            shoppingCart.getProductMap().replace(entry.getKey(), newQuantity);
        }
    }

    @Override
    public Integer countProductQuantity(ShoppingCart shoppingCart) {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProductMap().entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    @Override
    public Integer countItemQuantity(ShoppingCart shoppingCart) {
        return shoppingCart.getProductMap().size();
    }

    @Override
    public long countTotalPayment(ShoppingCart shoppingCart) {
        long payment = 0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProductMap().entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }

    @Override
    public void subProduct(Product product, ShoppingCart shoppingCart) {
        Map.Entry<Product, Integer> entry = selectItemInCart(product, shoppingCart);
        Integer newQuantity = entry.getValue() - 1;
        shoppingCart.getProductMap().replace(entry.getKey(), newQuantity);
    }

    @Override
    public void deleteItem(Product product, ShoppingCart shoppingCart) {
        Map<Product, Integer> integerMap = shoppingCart.getProductMap();
        Map.Entry<Product, Integer> entry = selectItemInCart(product, shoppingCart);
        integerMap.remove(entry.getKey());
        shoppingCart.setProductMap(integerMap);
    }

}
