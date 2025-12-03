package com.inkle.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkle.entity.User;
import com.inkle.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public User createUser(User user){
        return userService.createUser(user); 
    }
   @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
  
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id,@RequestParam String role){
         userService.deleteUser(id, role);
         return "User deleted successfully";
    }
}
