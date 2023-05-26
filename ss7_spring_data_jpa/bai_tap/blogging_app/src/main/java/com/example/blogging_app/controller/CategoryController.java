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

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ModelAndView displayBlogList(@RequestParam(value = "page", defaultValue = "0") int page) {
        return new ModelAndView("category/list", "categoryList", iCategoryService.findAllCategory(page));
    }

    @GetMapping("/create")
    public String redirectCreateBlog(Model model) {
        model.addAttribute("category", new Blog());
        return "category/create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        Boolean check = iCategoryService.addNewCategory(category);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/blog/create";
    }

    @GetMapping("/edit")
    public String showBlogUpdatePage(Model model, @RequestParam("category") Category category) {
        model.addAttribute("category", category);
        return "category/edit";
    }

    @GetMapping("/edit/{id}")
    public String sendBlog(Model model, @PathVariable("id") Integer id) {
        Blog blog = blogService.findBlogById(id);
        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("category", categoryList);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Boolean check = blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/blog/edit/" + blog.getId();
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Boolean check = blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String searchBlog(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "title", defaultValue = "")
    String title, String author, Model model) {
        Page<Blog> blogList = blogService.searchBlog(title, author, page);
        model.addAttribute("authors", author);
        model.addAttribute("titles", title);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/detail/{id}")
    public String showBlogDetail(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
}

