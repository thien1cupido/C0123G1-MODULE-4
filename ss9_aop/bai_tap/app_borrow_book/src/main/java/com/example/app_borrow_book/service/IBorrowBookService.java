package com.example.app_borrow_book.service;

import com.example.app_borrow_book.model.Book;
import com.example.app_borrow_book.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> borrowBookList();
    String createCodeName();

    Boolean borrowBook(String codeBook, Book book);
    BorrowBook findBookByNameCode(String nameCode);

    void returnTheBook(BorrowBook borrowBook);
}
