package com.example.blogging_app.service;

import com.example.blogging_app.model.Blog;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    Boolean save(Blog blog);
    List<Blog> searchBlog(String title);

    Slice<Blog> findAllBlog(Integer page);

    List<Blog> findAllBlogByCategory(Integer id);

}
