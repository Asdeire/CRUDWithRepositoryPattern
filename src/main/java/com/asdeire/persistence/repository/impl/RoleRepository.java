package com.asdeire.persistence.repository.impl;

import javax.management.relation.Role;
import java.util.List;

public interface RoleRepository {


    void save(Role role);

    Role findById(Long id);

    List<Role> findAll();

    void update(Role role);

    void delete(Role role);
}


