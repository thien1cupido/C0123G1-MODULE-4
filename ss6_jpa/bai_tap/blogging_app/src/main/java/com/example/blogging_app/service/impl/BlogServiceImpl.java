package com.example.blogging_app.service.impl;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.repository.IBlogRepository;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    public List<Blog> findAllBlog() {
        List<Blog> blogList = blogRepository.findAll();
        return blogList;
    }

    @Override
    public Boolean addNewBlog(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Blog findBlogById(Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        return blog;
    }

    @Override
    public Boolean editBlog(Blog blog) {
        try {
            blogRepository.save(blog);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteBlog(Integer id) {
        try {
            blogRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> searchBlog(String title,String author) {
        return blogRepository.searchBlog(title,author);
    }
}
