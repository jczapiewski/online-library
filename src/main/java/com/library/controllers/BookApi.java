package com.library.controllers;

import com.library.dao.entities.Book;
import com.library.manager.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {

    private BookManager manager;

    @Autowired
    public BookApi(BookManager manager) {
        this.manager = manager;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return manager.findAll();
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long id) {
        return manager.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return manager.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return manager.save(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long id) {
        manager.deleteById(id);
    }
}
