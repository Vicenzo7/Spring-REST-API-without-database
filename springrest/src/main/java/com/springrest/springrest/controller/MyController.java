package com.springrest.springrest.controller;

import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MyController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/home")
    public String home(){
        return "Welcome to User Management System";
    }

    // Get Users

    @GetMapping("/users")
    public List<User> getUser(){
        return this.userServices.getUser();

    }

    //single user
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long userId)
    {
        return  this.userServices.getUser(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return this.userServices.addUser(user);
    }

    // to update user
    @PutMapping("/users")
    public User updateUser(@PathVariable User user){
        return this.userServices.updateUser(user);

    }

    // to delete user
    @DeleteMapping("users/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        try{
            this.userServices.deleteUser(Long.parseLong(userId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
