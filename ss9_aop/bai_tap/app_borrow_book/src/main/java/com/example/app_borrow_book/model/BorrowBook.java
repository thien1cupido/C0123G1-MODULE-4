package com.example.app_borrow_book.model;


import javax.persistence.*;

@Entity
@Table(name = "borrow_book")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrow")
    private Integer id;
    @Column(name = "code_name",columnDefinition = "VARCHAR(5)")
    private String codeName;
    @OneToOne
    @JoinColumn(name = "id_book",referencedColumnName = "id_book")
    private Book book;
    private boolean statusBorrowBook;

    public BorrowBook(String codeName, Book book, boolean status) {
        this.codeName = codeName;
        this.book = book;
        this.statusBorrowBook = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public boolean isStatusBorrowBook() {
        return statusBorrowBook;
    }

    public void setStatusBorrowBook(boolean status) {
        this.statusBorrowBook = status;
    }
}
