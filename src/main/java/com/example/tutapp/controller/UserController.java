package com.example.tutapp.controller;

import com.example.tutapp.model.User;
import com.example.tutapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        userService.creerUtilisateur(user);
        return ResponseEntity.ok("Utilisateur sauvegardé avec succès");
    }
}
