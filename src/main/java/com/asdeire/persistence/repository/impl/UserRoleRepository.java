package com.asdeire.persistence.repository.impl;

import com.asdeire.persistence.model.UserRole;

import java.util.List;

public interface UserRoleRepository {
    void save(UserRole userRole);

    UserRole findById(Long id);

    List<UserRole> findAll();

    void update(UserRole userRole);

    void delete(UserRole userRole);
}
