package com.example.tutapp.controller;

import com.example.tutapp.model.User;
import com.example.tutapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tutapp.DTO.userDTO;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/all")
    public ResponseEntity<List<userDTO.ResponseUser>> getAllUser() {
        List<userDTO.ResponseUser> users = userService.GetAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<userDTO.ResponseUser> getUserById(@RequestParam("id") String id) {
        userDTO.ResponseUser response = userService.getUserById(id);
        return ResponseEntity.ok(response);
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
