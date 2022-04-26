package com.springrest.springrest.services;

import com.springrest.springrest.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    List<User> list;

    public UserServiceImpl(){
        list = new ArrayList<>();
        list.add(new User(145, "Deepraj","deeprajm35@gmail.com","8668221572"));
        list.add(new User(146, "Raj","Raj777@gmail.com","8678954512"));
    }


    @Override
    public List<User> getUser() {
        return list;
    }

    @Override
    public User getUser(long UserId) {

        User c=null;
        for(User user: list)
        {
            if(user.getId() == UserId )
            {
                c = user;
                break;
            }
        }
        return c;


    }

    @Override
    public User addUser(User user) {

        list.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        list.forEach( e-> {
            if(e.getId() == user.getId()) {
                e.setName((user.getName()));
                e.setEmail(user.getEmail());
                e.setNumber(user.getNumber());
            }
        });

        return user;
    }

    @Override
    public void deleteUser(long  parseLong) {
        list = this.list.stream().filter(e -> e.getId()!= parseLong).collect(Collectors.toList());

    }
}
