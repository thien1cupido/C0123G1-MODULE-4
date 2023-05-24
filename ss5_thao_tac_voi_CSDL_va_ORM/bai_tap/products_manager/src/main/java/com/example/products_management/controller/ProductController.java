package com.example.products_management.controller;

import com.example.products_management.model.Product;
import com.example.products_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String showProductList(Model model) {
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String showProductCreatePage(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("/edit")
    public String showProductUpdatePage(Model model, @RequestParam("product") Product product) {
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("Product") Product product, RedirectAttributes redirectAttributes) {
        Boolean check = productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/create";
    }

    @GetMapping("/edit/{id}")
    public String sendProduct(Model model, @PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        Boolean check = productService.editProduct(product);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/edit/" + product.getId();
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Boolean check = productService.deleteProductById(id);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchProduct(Model model, @RequestParam("nameSearch") String name) {
        List<Product> productList = productService.searchProductByName(name);
        model.addAttribute("productList", productList);
        return "list";
    }
}
