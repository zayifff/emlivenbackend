package com.emliven.emliven.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emliven.emliven.services.UserService;
import com.emliven.emliven.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }
    
    @GetMapping("/{userID}")
    public User getOneUser(@PathVariable Long userID) {
        return userService.getOneUser(userID);
    }
    
    @PutMapping("/{userID}")
    public User updateOneUser(@PathVariable Long userID, @RequestBody User newUser) {
        return userService.updateOneUser(userID, newUser);
    }
    
    @DeleteMapping("/{userID}")
    public void deleteOneUser(@PathVariable Long userID) {
        userService.deleteById(userID);
    }
}
