package com.example.blogging_app.service;

import com.example.blogging_app.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ICategoryService {

    List<Category> findAllCategory();

    Page<Category> findAllCategory(Integer numberPage);

    Boolean addNewCategory(Category category);

    Category findCategoryById(Integer id);

    Boolean editCategory(Category category);

    Boolean deleteCategory(Integer id);
}
