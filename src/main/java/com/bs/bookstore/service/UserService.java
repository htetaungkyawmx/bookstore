package com.bs.bookstore.service;

import com.bs.bookstore.entity.User;

import java.util.List;

public interface UserService {
   User save(User user);
   User findUserById(int id);
   List<User> findAll();
   void delete(User user);
}
