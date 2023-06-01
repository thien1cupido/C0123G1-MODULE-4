package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IProductService;
import com.example.shopping_cart.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IShoppingCartService iShoppingCartService;

    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("shoppingCart") ShoppingCart shoppingCart, Model model) {
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("countQuantity", iShoppingCartService.countItemQuantity(shoppingCart));
        model.addAttribute("countProduct", iShoppingCartService.countProductQuantity(shoppingCart));
        model.addAttribute("totalPayment", iShoppingCartService.countTotalPayment(shoppingCart));
        return "shopping_cart";
    }

    @GetMapping("/operation/{id}")
    public String operationToCart(@PathVariable("id") Integer id, @ModelAttribute ShoppingCart shoppingCart,@RequestParam(value = "action", required = false) String action) {
        Optional<Product> product = iProductService.findProductById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "increase":
                iShoppingCartService.addProduct(product.get(), shoppingCart);
                break;
            case "reduce":
                iShoppingCartService.subProduct(product.get(), shoppingCart);
                break;
            case "deleteItem":
                iShoppingCartService.deleteItem(product.get(),shoppingCart);
                break;
            default:
                iShoppingCartService.addProduct(product.get(), shoppingCart);
                return "redirect:/";
        }
        return "redirect:/shopping-cart";
    }
}
