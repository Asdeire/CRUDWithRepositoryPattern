package com.asdeire.persistence.repository.impl;

import com.asdeire.persistence.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void update(User user);

    void delete(User user);
}


