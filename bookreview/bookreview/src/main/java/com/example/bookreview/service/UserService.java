package com.example.bookreview.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bookreview.model.User;
import com.example.bookreview.repository.UserRepository;

@Service
public class UserService {
    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalArgumentException("User with id" + id + " does not exist");
        }
    }

    public void deleteRegiter(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User with id" + id + " does not exist.");
        }
    }
}
