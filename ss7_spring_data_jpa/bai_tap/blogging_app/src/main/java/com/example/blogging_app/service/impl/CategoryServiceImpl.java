package com.example.blogging_app.service.impl;

import com.example.blogging_app.model.Category;
import com.example.blogging_app.repository.ICategoryRepository;
import com.example.blogging_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Page<Category> findAllCategory(Integer numberPage) {
        Page<Category> categoryPage = iCategoryRepository.findAllByStatusIsFalseOrderByCreateTimeDesc(PageRequest.of(numberPage, 5));
        return categoryPage;
    }

    @Override
    public Boolean addNewCategory(Category category) {
        try {
            iCategoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
