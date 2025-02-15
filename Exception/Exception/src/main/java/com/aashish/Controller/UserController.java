package com.aashish.Controller;

import com.aashish.entity.User;
import com.aashish.request.UserRequest;
import com.aashish.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/created")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest, BindingResult result){


        if (result.hasErrors()){
            Map<String, String> error = new HashMap<>();
            for(FieldError error1: result.getFieldErrors()){
                error.put(error1.getField(),error1.getDefaultMessage());
            }
            return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

        }
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setAge(userRequest.getAge());

        userService.userSave(user);

        return new ResponseEntity<>("User is valid", HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

}
