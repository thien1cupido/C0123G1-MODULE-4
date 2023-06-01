package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IShoppingCartService;
import com.example.shopping_cart.service.impl.ShoppingCartServiceImpl;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("")
    public ModelAndView showList() {
        List<Product> productList = iProductService.findAllProduct();
        return new ModelAndView("list", "productList", productList);
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, @ModelAttribute ShoppingCart shoppingCart) {
        Optional<Product> product = iProductService.findProductById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        iShoppingCartService.addProduct(product.get(),shoppingCart);
        return "redirect:/";
    }
}