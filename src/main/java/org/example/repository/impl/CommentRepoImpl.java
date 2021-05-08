package org.example.repository.impl;

import org.example.model.Comment;
import org.example.repository.CommentRepo;
import org.example.util.SessionUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CommentRepoImpl extends SessionUtil implements CommentRepo {
    private Session session;

    @Override
    public void add(Comment comment) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(comment);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Comment> getAll() throws SQLException {
        openTransactionSession();
        String hql = "FROM Comment";
        Session session = getSession();
        List<Comment> comments = session.createQuery(hql).list();
        closeTransactionSesstion();
        return comments;
    }

    @Override
    public Comment getById(Long id) throws SQLException {
//open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Comment comment = session.get(Comment.class, id);
        //close session with a transaction
        closeTransactionSesstion();
        return comment;
    }

    @Override
    public Comment update(Comment comment) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.saveOrUpdate(comment);

        //close session with a transaction
        closeTransactionSesstion();
        return comment;
    }

    @Override
    public void delete(Long id) throws SQLException {
//open session with a transaction
        openTransactionSession();
        Session session = getSession();
        Comment comment = session.get(Comment.class, id);
        session.remove(comment);
        //close session with a transaction
        closeTransactionSesstion();
    }
}
