package com.example.app_borrow_book.repository;

import com.example.app_borrow_book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
    BorrowBook findBorrowBooksByCodeName(String codeName);
}
