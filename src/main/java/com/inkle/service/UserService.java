package com.inkle.service;

import java.util.List;


import com.inkle.entity.User;


public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id,String role);
    
}
