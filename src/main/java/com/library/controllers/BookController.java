package com.library.controllers;


import com.library.dao.BookRepository;
import com.library.dao.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {

    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @RequestMapping(value = "")
    public String index(Model model) {
        List<Book> books = (List<Book>) repository.findAll();
        model.addAttribute("title", "List of Books");
        model.addAttribute("books", books);

        return "books/index";
    }
}
