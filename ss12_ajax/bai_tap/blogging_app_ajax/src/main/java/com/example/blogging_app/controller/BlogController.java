package com.example.blogging_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BlogController {

    @GetMapping("")
    public String displayBlogList() {
        return "/blog/list";
    }

}
