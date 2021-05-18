package org.example.repository.impl;

import org.example.model.Book;
import org.example.model.Orders;
import org.example.repository.OrderRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class OrderRepoImpl extends SessionUtil implements OrderRepo {

    private Session session;

    @Override
    public Book add(Orders orders) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return null;
    }

    @Override
    public Orders getById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public Orders update(Orders data) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException {

    }
}
