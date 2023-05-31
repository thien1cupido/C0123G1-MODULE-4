package com.example.app_borrow_book.service;

import com.example.app_borrow_book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    Book findBookById(Integer id);

    Boolean editBook(Book book);
}
