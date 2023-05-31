package com.example.app_borrow_book.aspect;

import com.example.app_borrow_book.utils.LogFile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookAspect {

    @AfterReturning(value = "execution(* com.example.app_borrow_book.controller.BorrowBookController.borrowBook(..))",returning = "result")
    public void writeLogActionBorrow(JoinPoint joinPoint,Object result) {
        LogFile.writeToFileOfActionChangeStatus(joinPoint);
    }

    @AfterReturning(value = "execution(* com.example.app_borrow_book.controller.BorrowBookController.giveBackBook(..))",returning = "result")
    public void writeLogActionGiveBack(JoinPoint joinPoint,Object result) {
        LogFile.writeToFileOfActionChangeStatus(joinPoint);
    }

    @After(value = "execution(* com.example.app_borrow_book.controller.BorrowBookController.*(..))")
    public void logUserVisit() {
        LogFile.writeToFileOfVisitPage();
    }
}