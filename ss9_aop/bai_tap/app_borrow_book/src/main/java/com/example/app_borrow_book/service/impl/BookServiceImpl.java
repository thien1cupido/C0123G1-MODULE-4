package com.example.app_borrow_book.service.impl;

import com.example.app_borrow_book.model.Book;
import com.example.app_borrow_book.repository.IBookRepository;
import com.example.app_borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAllBook() {
        List<Book> bookList = iBookRepository.findAll();
        return bookList;
    }

    @Override
    public Book findBookById(Integer id) {
        return iBookRepository.findBookByIdBook(id);
    }

    @Override
    public Boolean editBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        try {
            iBookRepository.save(book);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
