package org.example.repository.impl;

import org.example.model.Book;
import org.example.repository.BookRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class BookRepoImpl extends SessionUtil implements BookRepo {

    private Session session;

    @Override
    public List<Book> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Book";
        Session session = getSession();
        List<Book> books = session.createQuery(hql).list();
        closeTransactionSesstion();
        return books;
    }

    @Override
    public Book getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Book book = session.get(Book.class, id);
        //close session with a transaction
        closeTransactionSesstion();
        return book;
    }

    @Override
    public Book add(Book book) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(book);

        //close session with a transaction
        closeTransactionSesstion();
        return book;
    }

    @Override
    public Book update(Book book) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(book);

        //close session with a transaction
        closeTransactionSesstion();
        return book;
    }

    @Override
    public void delete(Long id) throws SQLException {
//open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Book book = session.get(Book.class, id);
        session.remove(book);
        //close session with a transaction
        closeTransactionSesstion();
    }

    // idk
    @Override
    public List<Book> getBooksByUserId(Long userId) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Book> books = (List<Book>) session.get(Book.class, userId);
        closeTransactionSesstion();
        return books;
    }

}
