package com.example.shopping_cart.service;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.model.ShoppingCart;

public interface IShoppingCartService {
    void addProduct(Product product, ShoppingCart shoppingCart);

    Integer countProductQuantity(ShoppingCart shoppingCart);

    Integer countItemQuantity(ShoppingCart shoppingCart);

    long countTotalPayment(ShoppingCart shoppingCart);

    void subProduct(Product product, ShoppingCart shoppingCart);

    void deleteItem(Product product, ShoppingCart shoppingCart);

    void clearAllProduct(ShoppingCart shoppingCart);
}
