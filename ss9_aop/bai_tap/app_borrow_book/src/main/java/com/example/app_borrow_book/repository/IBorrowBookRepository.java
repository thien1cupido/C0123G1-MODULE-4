package com.example.app_borrow_book.repository;

import com.example.app_borrow_book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    List<BorrowBook> findAllByStatusIsTrue();

    BorrowBook findBorrowBooksByCodeName(String codeName);
}
