package com.example.app_borrow_book.controller;

import com.example.app_borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
        @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public ModelAndView showListBook() {
        return new ModelAndView("listBook", "bookList", iBookService.findAllBook());
    }

}
