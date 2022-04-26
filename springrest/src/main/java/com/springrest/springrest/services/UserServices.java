package com.springrest.springrest.services;

import com.springrest.springrest.entities.User;

import java.util.List;

public interface UserServices {

    public List<User> getUser();

    public User getUser(long userId );

    public  User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(long parseLong);



}
