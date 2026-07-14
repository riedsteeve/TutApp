package com.example.tutapp.controller;

import com.example.tutapp.model.User;
import com.example.tutapp.security.JwtUtil;
import jakarta.validation.constraints.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tutapp.DTO.LoginRequestDTO;
import com.example.tutapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request){
        //On vériefie que le User existe
        var UserExiste = userRepository.findByEmail(request.getEmail());

        if(UserExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrecte");
        }

        var utilisateur = UserExiste.get();

        //On vérifie son mdp avec Bcrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(request.getPassword(), utilisateur.getMdp())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou mot de passe incorrecte");
        }

        if(utilisateur.isDeleted()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ce compte a été supprimé");
        }

        //On génère ensuite le token
        String token = jwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
