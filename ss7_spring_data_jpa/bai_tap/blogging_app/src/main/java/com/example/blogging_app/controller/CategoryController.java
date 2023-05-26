package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.model.Category;
import com.example.blogging_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ModelAndView displayCategoryList(@RequestParam(value = "page", defaultValue = "0") int page) {
        return new ModelAndView("category/list", "categoryList", iCategoryService.findAllCategory(page));
    }

    @GetMapping("/create")
    public String redirectCreateCategory(Model model) {
        model.addAttribute("category", new Blog());
        return "category/create";
    }

    @PostMapping("/createBlog")
    public String createCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        Boolean check = iCategoryService.addNewCategory(category);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/category/create";
    }

    @GetMapping("/edit")
    public String showCategoryUpdatePage(Model model, @RequestParam("category") Category category) {
        model.addAttribute("category", category);
        return "category/edit";
    }

    @GetMapping("/edit/{id}")
    public String sendCategory(Model model, @PathVariable("id") Integer id) {
        Category category = iCategoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/editCategory")
    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        Boolean check = iCategoryService.editCategory(category);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/category/edit/" + category.getIdCategory();
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Boolean check = iCategoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/category";
    }

}

