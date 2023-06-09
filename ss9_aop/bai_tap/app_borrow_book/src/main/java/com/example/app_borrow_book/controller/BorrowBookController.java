package com.example.app_borrow_book.controller;

import com.example.app_borrow_book.model.Book;
import com.example.app_borrow_book.model.BorrowBook;
import com.example.app_borrow_book.service.IBookService;
import com.example.app_borrow_book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BorrowBookController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookService iBorrowBookService;
    @GetMapping("/borrowBook")
    public ModelAndView showBorrowedBooks(){
        List<BorrowBook>borrowBookList=iBorrowBookService.borrowBookList();
        return new ModelAndView("listBorrow","listBorrowBook",borrowBookList);
    }
    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id) {
        Book book = iBookService.findBookById(id);
        Boolean check = iBookService.editBook(book);
        if (check) {
            String codeName=iBorrowBookService.createCodeName();
            iBorrowBookService.borrowBook(codeName,book);
            return "redirect:/";
        } else {
            return "error";
        }
    }
    @PostMapping("/borrowBook")
    public String giveBackBook(@RequestParam("codeBook") String codeBook){
        if (codeBook==null){
            return "redirect:/showError";
        }
        BorrowBook borrowBook =iBorrowBookService.findBookByNameCode(codeBook);
        iBorrowBookService.returnTheBook(borrowBook);
        return "redirect:/borrowBook";
    }
//    @ExceptionHandler({NullPointerException.class})
//    public String showError(Model model){
//        String error="Error: Do not enter the book code";
//        model.addAttribute("error",error);
//        return "error";
//    }
}
