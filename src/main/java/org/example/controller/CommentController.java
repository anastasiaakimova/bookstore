package org.example.controller;

import org.example.model.Comment;
import org.example.model.User;
import org.example.repository.CommentRepo;
import org.example.repository.impl.CommentRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class CommentController {
    private CommentRepo commentRepo = new CommentRepoImpl();

    public List<Comment> printAll() throws SQLException {
        return commentRepo.getAll();
    }

    public void saveComment(Comment newComment) throws SQLException {
        commentRepo.add(newComment);
    }

    public void deleteComment(Long id) throws SQLException {
        commentRepo.delete(id);
    }

    public void updateComment(Comment updateComment) throws SQLException {
        commentRepo.update(updateComment);
    }

    public Comment getValueById(Long id) throws SQLException {
        return commentRepo.getById(id);
    }
}
