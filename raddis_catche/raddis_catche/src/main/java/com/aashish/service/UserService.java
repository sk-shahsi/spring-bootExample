package com.aashish.service;

import com.aashish.entity.User;
import com.aashish.reop.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Cacheable(value ="users",key ="#id")
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    @CachePut(value = "users", key ="#user.id")
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @CacheEvict(value ="user" ,key="#id")
    public void deletUser(Long id){
        userRepository.findById(id);
    }
}
