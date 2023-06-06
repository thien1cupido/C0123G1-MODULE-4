package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<Slice<Blog>> displayBlogList() {
        return new ResponseEntity<>(iBlogService.findAllBlog(0), HttpStatus.OK);
    }
    @GetMapping("/list/loadMore")
    public ResponseEntity<Slice<Blog>> displayBlogListLoadMore(@RequestParam("page")Integer page) {
        return new ResponseEntity<>(iBlogService.findAllBlog(page), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Blog>> displayBlogListByCategory(@RequestParam("id")Integer id) {
        return new ResponseEntity<>(iBlogService.findAllBlogByCategory(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findBlogByTitleAndAuthor(@RequestParam("titles")String title) {
        return new ResponseEntity<>(iBlogService.searchBlog(title), HttpStatus.OK);
    }

}

