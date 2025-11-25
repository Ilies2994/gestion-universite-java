package com.universite.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Personne {
    // Les attributs restent protected pour l'accès dans les sous-classes
    protected String id;
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String email;
    protected String telephone;
    protected Adresse adresse;

    public Personne(String id, String nom, String prenom, LocalDate dateNaissance, 
                    String email, String telephone, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public abstract String getRole();
    public abstract void afficherInfos();

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    // CORRECTION : Tous les getters sont maintenant PUBLIC
    public String getId() { return id; }
    public String getNom() { return nom; }  // ✅ Maintenant public
    public String getPrenom() { return prenom; }  // ✅ Maintenant public
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public Adresse getAdresse() { return adresse; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateNaissance(LocalDate dateNaissance) { 
        this.dateNaissance = dateNaissance; 
    }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(id, personne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}