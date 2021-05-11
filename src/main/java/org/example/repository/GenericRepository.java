package org.example.repository;

import org.example.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {
    //create
    Book add(T t) throws SQLException;

    //read
    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    //update
    T update(T data) throws SQLException;

    //delete
    void delete(ID id) throws SQLException;
}
