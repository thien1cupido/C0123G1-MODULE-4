package com.example.app_borrow_book.service.impl;

import com.example.app_borrow_book.model.Book;
import com.example.app_borrow_book.model.BorrowBook;
import com.example.app_borrow_book.repository.IBorrowBookRepository;
import com.example.app_borrow_book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BorrowBookServiceImpl implements IBorrowBookService {

    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;
    @Override
    public  List<BorrowBook>borrowBookList(){
      return iBorrowBookRepository.findAll();
    }
    @Override
    public String createCodeName() {
        String result="";
        boolean check=true;
        do {
        Integer codeName= ThreadLocalRandom.current().nextInt(1,99999);
        if (codeName<10000){
            result="0"+codeName;
        } else if (codeName<1000) {
            result="00"+codeName;
        }else if (codeName<100){
            result="000"+codeName;
        }else if (codeName<10){
            result="0000"+codeName;
        }else {
            result=""+codeName;
        }
        BorrowBook borrowBook =iBorrowBookRepository.findBorrowBooksByCodeName(result);
            if (borrowBook!=null){
                check=false;
            }
        }while (!check);
        return result;
    }

    @Override
    public Boolean borrowBook(String codeBook,Book book) {
        BorrowBook borrowBook=new BorrowBook(codeBook,book,true);
        try {
            iBorrowBookRepository.save(borrowBook);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
