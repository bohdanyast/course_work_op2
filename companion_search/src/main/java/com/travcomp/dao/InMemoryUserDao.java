package com.travcomp.dao;

import com.travcomp.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryUserDao implements UserDao {
    private List<User> users = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void create(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    @Override
    public Collection<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        users.removeIf(user -> user.getId() == id);
    }


    public User validateUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
