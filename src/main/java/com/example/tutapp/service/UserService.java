package com.example.tutapp.service;

import com.example.tutapp.model.User;
import com.example.tutapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.tutapp.DTO.userDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.OffsetDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public userDTO.ResponseUser createUser(userDTO.CreateUser createUser) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        try {
            User utilisateur = new User();
            utilisateur.setNom(createUser.nom());
            utilisateur.setPrenom(createUser.prenom());
            utilisateur.setEmail(createUser.email());

            String hashedPassword = passwordEncoder.encode(createUser.mdp());

            utilisateur.setMdp(hashedPassword);
            utilisateur.setUsername(createUser.username());
            utilisateur.setCreated_At(OffsetDateTime.now());

            User pushUser = userRepository.save(utilisateur);
            System.out.println("Succes: Utililisateur créé" + pushUser.getId());

            return new userDTO.ResponseUser(
                    pushUser.getNom(),
                    pushUser.getPrenom(),
                    pushUser.getEmail(),
                    pushUser.getUsername()
            );
        }
        catch (Exception ex){
            System.out.println("Erreur: UserService");
            throw ex;
        }
    }


    public boolean DeleteUser(String id) {
        //On vérifie si le User existe d'abord
        var ExisteUser = userRepository.findById(id);

        if(ExisteUser.isEmpty()) {
            return false;
        }

        User utilisateur = ExisteUser.get();

        utilisateur.setDeleted(true);
        userRepository.save(utilisateur);
        System.out.println("Succes: Utilisateur supprimé avec succes");

        return true;
    }










}
