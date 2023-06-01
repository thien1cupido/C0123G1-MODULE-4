package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IShoppingCartService;
import com.example.shopping_cart.service.impl.ShoppingCartServiceImpl;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("shoppingCart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IShoppingCartService iShoppingCartService;

    @ModelAttribute("shoppingCart")
    public ShoppingCart setupCart() {
        return new ShoppingCart();
    }

    @GetMapping("/")
    public String showList(@ModelAttribute("shoppingCart")ShoppingCart shoppingCart, Model model) {
        List<Product> productList = iProductService.findAllProduct();
        model.addAttribute("productList",productList);
        Integer countItem=iShoppingCartService.countItemQuantity(shoppingCart);
        if (countItem==null){
            countItem=0;
        }
        model.addAttribute("countItem",countItem);
        return"list";
    }
}