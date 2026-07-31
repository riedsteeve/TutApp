package com.example.tutapp.controller;

import com.example.tutapp.model.User;
import com.example.tutapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tutapp.DTO.userDTO;

import java.util.UUID;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestParam("id") String id, @RequestBody userDTO.CreateUser updateUser){
        try{
        userDTO.ResponseUser response = userService.updateUser(id, updateUser);

        return ResponseEntity.ok(response);
        }
        catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@RequestParam("id") String id) {
        boolean estSupprime = userService.DeleteUser(id);

        if(!estSupprime){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppression impossible: Utilisateur non trouvé");
        }

        return ResponseEntity.ok("Ustilisateur supprimé avec succès");
    }
}
