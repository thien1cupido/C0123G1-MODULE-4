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
    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName = "id_book")
    private Book book;
    private boolean status;

    public BorrowBook(String codeName, Book book, boolean status) {
        this.codeName = codeName;
        this.book = book;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
