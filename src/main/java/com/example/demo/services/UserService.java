package com.example.demo.services;

import com.example.demo.aspects.TrackTime;
import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User, Integer, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }

    @TrackTime
    public Page<User> getUsersByEmail(String email, Pageable pageable) {
        return repository.getUsersByEmail(email, pageable);
    }
}
