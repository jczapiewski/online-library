package com.library;

import com.library.entities.Book;
import com.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Start {

    private BookRepository repo;

    @Autowired
    public Start(BookRepository repo) {
        this.repo = repo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        Book lotr = new Book("Lord of The Rings", "JRR Tolkien");
        repo.save(lotr);
    }
}
