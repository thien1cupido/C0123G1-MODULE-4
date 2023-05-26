package com.example.blogging_app.service.impl;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.repository.IBlogRepository;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAllBlogAndPage(Integer integer) {
        Page<Blog> blogPage = blogRepository.findAllByStatusIsFalseOrderByCreateTimeDesc(PageRequest.of(integer,5));
        return blogPage;
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
        Blog blog = blogRepository.getReferenceById(id);
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
            blogRepository.deleteBlogById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Page<Blog> searchBlog(String title,String author,Integer page) {
        return blogRepository.searchBlog(PageRequest.of(page,5),title,author);
    }

}
