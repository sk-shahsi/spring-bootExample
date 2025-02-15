package com.aashish.services;

import com.aashish.entity.User;
import com.aashish.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User userSave(User user){
        return userRepo.save(user);
    }
    public List<User> getAllUser(){

        return userRepo.findAll();
    }


}
