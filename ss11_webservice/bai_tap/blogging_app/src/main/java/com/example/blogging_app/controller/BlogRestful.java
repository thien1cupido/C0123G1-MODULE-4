package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
public class BlogRestful {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> displayBlogList() {
        return new ResponseEntity<>(iBlogService.findAllBlog(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Blog>> displayBlogListByCategory(@RequestParam("id")Integer id) {
        return new ResponseEntity<>(iBlogService.findAllBlogByCategory(id), HttpStatus.OK);
    }
    @GetMapping("/detail")
    public ResponseEntity<Blog> displayBlog(@RequestParam("id")Integer id){
        return new ResponseEntity<>(iBlogService.findBlogById(id), HttpStatus.OK);
    }
}

