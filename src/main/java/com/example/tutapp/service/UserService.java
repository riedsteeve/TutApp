package com.example.tutapp.service;

import com.example.tutapp.model.User;
import com.example.tutapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void creerUtilisateur(User user) {
        try {
            user.setId(null); // Force la génération d'un nouvel ID par JPA
            User savedUser = userRepository.save(user);
            System.out.println("Success: Utilisateur sauvegardé avec ID: " + savedUser.getId());
        } catch (Exception e) {
            System.err.println("Erreur de connexion base de données: " + e.getMessage());
        }
    }
}
