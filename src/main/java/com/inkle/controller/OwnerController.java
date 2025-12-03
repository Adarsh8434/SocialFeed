package com.inkle.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.entity.User;
import com.inkle.repository.UserRepository;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final UserRepository userRepository;

    public OwnerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/make-admin/{userId}")
    public String makeAdmin(@PathVariable Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole("ADMIN");
        userRepository.save(user);

        return "Admin created by owner";
    }

    @DeleteMapping("/make-admin/{userId}")
    public String removeAdmin(@PathVariable Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole("USER");
        userRepository.save(user);

        return "Admin removed by owner";
    }

}