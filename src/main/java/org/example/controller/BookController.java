package org.example.controller;

import org.example.model.Book;

import org.example.repository.BookRepo;
import org.example.repository.impl.BookRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class BookController {

    private BookRepo bookRepo = new BookRepoImpl();

    public Book createBook(Book book) throws SQLException {
        return bookRepo.add(book);
    }

    public Book getBookById(Long id) throws SQLException {
        return bookRepo.getById(id);
    }

    public Book editBook(Book book) throws SQLException {
        return bookRepo.update(book);
    }

    public void deleteBookById(Long id) throws SQLException {
        bookRepo.delete(id);
    }

    public List<Book> showAllBooks() throws SQLException {
        return bookRepo.getAll();
    }

    public List<Book> getBooksByUserId(Long id) throws SQLException {
        return bookRepo.getBooksByUserId(id);
    }

}