package com.library.manager;


import com.library.dao.BookRepository;
import com.library.dao.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookManager {

    private BookRepository repository;

    @Autowired
    public BookManager (BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addDataToDB() {
        if (repository.count() == 0L) {
            save(new Book("Harry Potter", "JK Rowling"));
            save(new Book("Game of Thrones", "George RR Martin"));
            save(new Book("Lord of The Rings", "JRR Tolkien"));
        }
    }
}
