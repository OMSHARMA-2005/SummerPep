package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String register(User user) {

        Optional<User> existing = repository.findByUsername(user.getUsername());

        if (existing.isPresent()) {
            return "Username already exists";
        }

        repository.save(user);

        return "Registration Successful";
    }

}