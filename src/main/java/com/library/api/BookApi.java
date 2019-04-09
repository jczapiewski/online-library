package com.library.api;

import com.library.dao.entities.Book;
import com.library.manager.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookApi {

    private BookManager manager;

    @Autowired
    public BookApi(BookManager manager) {
        this.manager = manager;
    }

    @GetMapping("/books")
    public Iterable<Book> getAll() {
        return manager.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable(value = "id") Long id) {
        return manager.findById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return manager.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable(value = "id") Long id, @RequestBody Book book) {
        return manager.update(id, book);
    }

    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id) {
        manager.deleteById(id);
    }
}
