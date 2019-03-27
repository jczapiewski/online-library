package com.library.controllers;

import com.library.entities.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookList {

    private List<Book> bookList;

    public BookList() {
        this.bookList = new ArrayList<Book>();
    }

    @RequestMapping("/api")
    public List<Book> list() {
        bookList.add(new Book("Harry Potter", "JK Rowling"));
        bookList.add(new Book("Game of Thrones", "Gorege RR Martin|"));
        bookList.add(new Book("Lord of The Rings", "JRR Tolkien"));
        return bookList;
    }
}
