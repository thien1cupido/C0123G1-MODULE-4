package com.example.blogging_app.service.impl;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.repository.IBlogRepository;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> searchBlog(String title) {
        return blogRepository.searchBlog(title);
    }

    @Override
    public Slice<Blog> findAllBlog(Integer page) {
        return blogRepository.findAllBlog(PageRequest.of(page,5));
    }

    @Override
    public List<Blog> findAllBlogByCategory(Integer id) {
        return blogRepository.findAllByCategory(id);
    }

}
