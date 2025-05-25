package org.example.TP2.EXO2;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters pour capturer les données dans Exercice 3
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
}

