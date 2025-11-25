package com.universite.model;

import java.time.LocalDate;

public class Inscription {
    private Etudiant etudiant;
    private Cours cours;
    private LocalDate dateInscription;
    private String statut;

    public Inscription(Etudiant etudiant, Cours cours, LocalDate dateInscription) {
        this.etudiant = etudiant;
        this.cours = cours;
        this.dateInscription = dateInscription;
        this.statut = "Inscrit";
    }

    public void valider() { this.statut = "Validé"; }
    public void echouer() { this.statut = "Échoué"; }
    public void abandonner() { this.statut = "Abandonné"; }

    // Getters et Setters
    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }

    public LocalDate getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDate dateInscription) { 
        this.dateInscription = dateInscription; 
    }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "Inscription{" +
                "etudiant=" + etudiant.getNomComplet() +
                ", cours=" + cours.getNom() +
                ", date=" + dateInscription +
                ", statut='" + statut + '\'' +
                '}';
    }
}