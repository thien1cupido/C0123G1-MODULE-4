package com.example.app_borrow_book.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;
    @Column(name = "name_book")
    private String nameBook;
    @Range(min = 0)
    private Integer quantity;
    public Book() {
    }

    public Book(Integer idBook, String nameBook, Integer quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

}
