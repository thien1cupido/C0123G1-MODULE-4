package com.example.blogging_app.controller;

import com.example.blogging_app.model.Category;
import com.example.blogging_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/category")
public class CategoryRestful {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> displayCategoryList() {
        return new ResponseEntity<>(iCategoryService.findAllCategory(), HttpStatus.OK);
    }
}
