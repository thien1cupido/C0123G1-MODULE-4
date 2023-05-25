package com.example.blogging_app.service;

import com.example.blogging_app.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAllBlog();

    Boolean addNewBlog(Blog blog);

    Blog findBlogById(Integer id);

    Boolean editBlog(Blog blog);

    Boolean deleteBlog(Integer id);

    List<Blog> searchBlog(String title,String author);
}
