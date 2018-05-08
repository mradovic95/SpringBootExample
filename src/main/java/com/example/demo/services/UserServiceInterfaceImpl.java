package com.example.demo.services;

import com.example.demo.aspects.TrackTime;
import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    @TrackTime
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @TrackTime
    public User getById(int id) {
        Optional<User> entity = userRepository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    @Override
    @TrackTime
    public void add(User entity) {
        userRepository.save(entity);
    }

    @Override
    @TrackTime
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @TrackTime
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    @TrackTime
    public Page<User> getUsersByEmail(String email, Pageable pageable) {
        return userRepository.getUsersByEmail(email, pageable);
    }
}
