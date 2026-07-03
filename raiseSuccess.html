package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public void validate(String username, String password) {

        Optional<User> optional = repository.findByUsername(username);

        if (optional.isEmpty()) {
            throw new InvalidCredentialsException("Invalid Username or Password");
        }

        User user = optional.get();

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid Username or Password");
        }
    }
}