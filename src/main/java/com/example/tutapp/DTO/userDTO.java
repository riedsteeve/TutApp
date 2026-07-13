package com.example.tutapp.DTO;

public class userDTO {

    public record CreateUser(String nom, String prenom, String username, String email, String mdp) {

    }

    public record ResponseUser(String nom, String prenom, String username, String email) {

    }

}
