package com.aashish.controller;

import com.aashish.entity.User;
import com.aashish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{redis}")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){

        User user = userService.getUserById(id);

        return user != null ? ResponseEntity.ok(user):
                ResponseEntity.notFound().build();
    }
    @PostMapping
    public  ResponseEntity<User> createUser(@RequestBody User user){

        User saveUser = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    public ResponseEntity<Void> deletUser(@PathVariable Long id){
        userService.deletUser(id);

        return ResponseEntity.noContent().build();
    }
}
