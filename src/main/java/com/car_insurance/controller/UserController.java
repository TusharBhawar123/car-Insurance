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
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        try {
            this.userService.saveUser(user);
            return ResponseEntity.ok("User Added Successfully");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.getAllUsers(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setUserId(id);
        return ResponseEntity.ok(this.userService.updateUser(user,id));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        ResponseEntity<Object> responseEntity=new ResponseEntity<>(HttpStatus.NO_CONTENT);
        this.userService.deleteById(id);
        System.out.println(responseEntity);
        return "User Successfully Deleted";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping("/firstname/{firstName}")
    public List<User> findByUserFirstName(@PathVariable String firstName,@RequestBody User user) {
        return this.userService.findByUserFirstName(firstName);
    }
    
    @GetMapping("/LastName/{lastName}")
    public List<User> findByUserLastName(@PathVariable String lastName,@RequestBody User user){
        return this.userService.findByUserLastName(lastName);
    }


}
