package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.service.IBlogService;
import javafx.beans.binding.BooleanBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String showProductList(Model model) {
        List<Blog> blogList = blogService.findAllBlog();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String redirectCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes) {
        Boolean check=blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("check",check);
        return "redirect:/create";
    }
    @GetMapping("/edit")
    public String showBlogUpdatePage(Model model, @RequestParam("product") Blog blog) {
        model.addAttribute("blog", blog);
        return "edit";
    }
    @GetMapping("/edit/{id}")
    public String sendBlog(Model model, @PathVariable("id") Integer id) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }
    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Boolean check = blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/edit/" + blog.getId();
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id")Integer id,RedirectAttributes redirectAttributes){
        Boolean check=blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("check", check);
        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchBlog(@RequestParam String title, @RequestParam String author,Model model){
        List<Blog>blogList=blogService.searchBlog(title,author);
        model.addAttribute("authors",author);
        model.addAttribute("titles",title);
        model.addAttribute("blogList",blogList);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public String showBlogDetail(@PathVariable Integer id,Model model){
        Blog blog=blogService.findBlogById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
}
