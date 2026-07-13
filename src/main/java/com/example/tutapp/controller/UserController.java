package com.example.tutapp.controller;

import com.example.tutapp.model.User;
import com.example.tutapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tutapp.DTO.userDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<userDTO.ResponseUser> create(@RequestBody userDTO.CreateUser user) {
        userDTO.ResponseUser response = userService.createUser(user);
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
