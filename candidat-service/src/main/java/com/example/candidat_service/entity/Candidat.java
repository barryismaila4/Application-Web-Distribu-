package com.example.candidat_service.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @ElementCollection
    private Set<Long> favoriteJobIds = new HashSet<>();

    // Constructeurs
    public Candidat() {}

    public Candidat(String nom, String prenom, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Set<Long> getFavoriteJobIds() { return favoriteJobIds; }
    public void setFavoriteJobIds(Set<Long> favoriteJobIds) { this.favoriteJobIds = favoriteJobIds; }
}