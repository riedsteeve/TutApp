package com.example.tutapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String username;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;
    private OffsetDateTime created_At;
    private OffsetDateTime updated_At;
}

