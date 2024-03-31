package com.bs.bookstore.service;

import com.bs.bookstore.dto.UserDTO;
import com.bs.bookstore.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   User save(UserDTO userDTO);
   User findUserById(Integer id);

   Optional<User> findUserByEmail(String email);
   List<User> findAll();
}
