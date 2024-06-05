package com.travcomp.dao;

import com.travcomp.model.Trip;
import com.travcomp.model.User;

import java.util.Collection;

public interface UserDao {
    void create(User user);

    Collection<User> findAll();

    User findById(Integer id);

    void deleteById(Integer id);
}
