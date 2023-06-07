package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.model.Category;
import com.example.blogging_app.service.IBlogService;
import com.example.blogging_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String displayLoginPage() {
        return "loginPage";
    }

    @GetMapping("/list")
    public String displayBlogList() {
        return "list";
    }

    @GetMapping("/create")
    public String redirectCreateBlog(Model model) {
        List<Category> categoryList = iCategoryService.findAllCategory();
        model.addAttribute("category", categoryList);
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Boolean check = iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/create";
    }
}
