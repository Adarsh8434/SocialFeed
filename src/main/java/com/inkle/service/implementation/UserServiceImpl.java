package com.inkle.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inkle.entity.User;
import com.inkle.repository.UserRepository;
import com.inkle.service.ActivityService;
import com.inkle.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final ActivityService activityService;

    public UserServiceImpl(UserRepository userRepository, ActivityService activityService){
        this.userRepository = userRepository;
        this.activityService = activityService;
    }
    @Override
    public User createUser(User user) {
       User save=userRepository.save(user);
       return save;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
      return userRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteUser(Long id, String role) {
       if(!role.equals("ADMIN") && !role.equals("OWNER")) throw new RuntimeException("Only admin or owner can delete user");

       User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

       user.setDeleted(true);
       userRepository.save(user);
       activityService.logActivity(    "USER_DELETED",
                id,
                null,
                null
        );
    }

}
