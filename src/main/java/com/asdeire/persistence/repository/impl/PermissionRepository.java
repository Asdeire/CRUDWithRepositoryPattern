package com.asdeire.persistence.repository.impl;

import com.asdeire.persistence.model.Permission;

import java.util.List;

public interface PermissionRepository {

    void save(Permission permission);

    Permission findById(Long id);

    List<Permission> findAll();

    void update(Permission permission);

    void delete(Permission permission);
}


