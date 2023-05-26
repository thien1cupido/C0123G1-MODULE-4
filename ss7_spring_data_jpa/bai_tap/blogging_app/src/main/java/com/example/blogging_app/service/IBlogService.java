package com.example.blogging_app.service;

import com.example.blogging_app.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAllBlogAndPage(Integer integer);

    Boolean addNewBlog(Blog blog);

    Blog findBlogById(Integer id);

    Boolean editBlog(Blog blog);

    Boolean deleteBlog(Integer id);

    Page<Blog> searchBlog(String title,String author,Integer page);
}
