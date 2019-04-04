package com.library.dao;

import com.library.dao.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    public Book findOneByTitle(String title);
}
