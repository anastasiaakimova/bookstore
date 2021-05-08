package org.example.repository.impl;

import org.example.model.User;
import org.example.repository.UserRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserRepoImpl extends SessionUtil implements UserRepo {
    private Session session;

    @Override
    public void add(User user) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(user);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<User> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM User";
        Session session = getSession();
        List<User> users = session.createQuery(hql).list();
        closeTransactionSesstion();
        return users;
    }

    @Override
    public User getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();
        Session session = getSession();
        User user = session.get(User.class, id);
        //close session with a transaction
        closeTransactionSesstion();
        return user;
    }

    @Override
    public User update(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(user);

        //close session with a transaction
        closeTransactionSesstion();
        return user;
    }

    @Override
    public void delete(Long id) throws SQLException {
//open session with a transaction
        openTransactionSession();
        Session session = getSession();
        User user = session.get(User.class, id);
        session.remove(user);
        //close session with a transaction
        closeTransactionSesstion();
    }
}
