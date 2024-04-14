package com.car_insurance.controller;

import com.car_insurance.entity.User;
import com.car_insurance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.getAllUsers(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id) {
        user.setUserId(id);
        return ResponseEntity.ok(this.userService.updateUser(user,id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        ResponseEntity<Object> responseEntity=new ResponseEntity<>(HttpStatus.NO_CONTENT);
        this.userService.deleteById(id);
        System.out.println(responseEntity);
    }
}
