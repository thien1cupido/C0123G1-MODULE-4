package com.example.blogging_app.service;

import com.example.blogging_app.model.Category;
import org.springframework.data.domain.Page;


public interface ICategoryService {

    Page<Category> findAllCategory(Integer numberPage);

    Boolean addNewCategory(Category category);

}
