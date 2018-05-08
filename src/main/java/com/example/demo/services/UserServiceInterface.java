package com.example.demo.services;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserServiceInterface {

    Page<User> getAll(Pageable pageable);

    User getById(int id);

    void add(User entity);

    void delete(int id);

    void update(User entity);

    Page<User> getUsersByEmail(String email, Pageable pageable);

}
