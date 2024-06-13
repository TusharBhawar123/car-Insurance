package com.car_insurance.service;

import com.car_insurance.ExceptionHandler.UserAlreadyDeleted;
import com.car_insurance.ExceptionHandler.UserAlreadyExits;
import com.car_insurance.ExceptionHandler.UserNotFound;
import com.car_insurance.entity.User;
import com.car_insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        Optional<User> exitingUser=userRepository.findByUserFirstName(user.getFirstName());
        if(exitingUser.isPresent()){
            throw new UserAlreadyExits("User already exits");
        }else{
            return this.userRepository.save(user);
        }
    }

    public List<User> getAllUsers(User user) {
        return this.userRepository.findAll();
    }

    public User updateUser(User user, Long id) {
        user.setUserId(id);
        return this.saveUser(user);
    }

    public void deleteById(Long id){
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()) {
            this.userRepository.deleteById(id);
        }else{
            throw new UserAlreadyDeleted("User Already Deleted ->"+id+" this is User Not Present In Database Any More");
        }
    }

    public User findById(Long id)throws UserNotFound {
        return this.userRepository.findById(id).orElseThrow(
                () -> new UserNotFound("User Not Found -> " + id + " this user not in Database ")
        );
    }

    public List<User> findByUserFirstName(String userFirstName) {
        return Collections.singletonList(this.userRepository.findByUserFirstName(userFirstName).stream().findFirst().orElseThrow(() -> {
            throw new UserNotFound("User Not Found -> " + userFirstName + " this user not in Database ");
        }));
    }

    public List<User> findByUserLastName(String userLastName){
        return Collections.singletonList(this.userRepository.findByLastName(userLastName).stream().findFirst().orElseThrow(
                ()-> {
                    throw new UserNotFound("User not Found ->" + userLastName + "this User not in DataBase");
                }));
    }

}
