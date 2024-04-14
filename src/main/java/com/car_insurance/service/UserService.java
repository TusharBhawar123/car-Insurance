package com.car_insurance.service;

import com.car_insurance.entity.User;
import com.car_insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers(User user) {
        return userRepository.findAll();
    }

    public User updateUser(User user,Long id){
        user.setUserId(id);
        return this.saveUser(user);
    }

    public void deleteById(Long id){
        this.userRepository.deleteById(id);
    }
}
