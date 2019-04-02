package com.library.manager;


import com.library.dao.BookRepository;
import com.library.dao.entities.Author;
import com.library.dao.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BookManager {

    private BookRepository repository;

    @Autowired
    public BookManager (BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }

    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Book update(Long id, Book book) {
        Book updatedBook = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthors(book.getAuthors());
        return repository.save(updatedBook);
    }

    public void deleteById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        repository.delete(book);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addDataToDB() {
        if (repository.count() == 0L) {
            save(new Book("Harry Potter", new Author("Joanne Kathleen", "Rowling")));
            save(new Book("Game of Thrones", new Author("George Raymond Richard", "Martin")));
            save(new Book("Lord of The Rings", new Author("John Ronald Reuel", "Tolkien")));
        }
    }
}
