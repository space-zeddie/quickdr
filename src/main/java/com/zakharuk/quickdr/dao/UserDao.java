package com.zakharuk.quickdr.dao;

import com.zakharuk.quickdr.entity.User;

/**
 * Created by matvii on 13.04.17.
 */
public interface UserDao {

    User get(String login);
    int add(User user);
    void update(User user);
    void remove(User user);
    boolean exists(User user);
}
