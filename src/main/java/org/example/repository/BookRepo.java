package org.example.repository;

import org.example.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo extends GenericRepository<Book, Long> {
    List<Book> getBooksByUserId(Long id) throws SQLException;
}
