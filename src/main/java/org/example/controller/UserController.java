package org.example.controller;


import org.example.model.User;
import org.example.repository.GenericRepository;
import org.example.repository.impl.UserRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private GenericRepository userRepo = new UserRepoImpl();

    public List<User> printAll() throws SQLException {
        return userRepo.getAll();
    }

    public void saveUser(User newUser) throws SQLException {
        userRepo.add(newUser);
    }

    public void deleteUser(Long id) throws SQLException {
        userRepo.delete(id);
    }

    public void updateUser(User updateUser) throws SQLException {
        userRepo.update(updateUser);
    }

    public User getUserById(Long id) throws SQLException {
        return (User) userRepo.getById(id);
    }
}
