package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService iShoppingCartService;

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("countQuantity",iShoppingCartService.countItemQuantity(shoppingCart));
        model.addAttribute("countProduct",iShoppingCartService.countProductQuantity(shoppingCart));
        model.addAttribute("totalPayment",iShoppingCartService.countTotalPayment(shoppingCart));
        return "shopping_cart";
    }
}
