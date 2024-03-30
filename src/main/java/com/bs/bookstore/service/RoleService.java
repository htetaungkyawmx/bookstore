package com.bs.bookstore.service;

import com.bs.bookstore.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
}
